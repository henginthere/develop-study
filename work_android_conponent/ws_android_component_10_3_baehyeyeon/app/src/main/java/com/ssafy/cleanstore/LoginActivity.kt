package com.ssafy.cleanstore

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.messaging.FirebaseMessaging
import com.ssafy.cleanstore.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "LoginActivity_싸피"
private lateinit var binding: ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //어디서든 호출할 수 있는 companion object
    companion object {
        // Notification Channel ID
        const val channel_id = "ssafy_channel"

        // RetroFit 수업 후 Network 에 업로드 할 수 있도록 구성
        fun uploadToken(token: String) {
            // 새로운 토큰 수신 시 서버로 전송
            val storeService = ApplicationClass.retrofit.create(FirebaseTokenService::class.java)
            storeService.uploadToken(token).enqueue(object : Callback<String> {

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful) {
                        val res = response.body()
                        Log.d(TAG, "onResponse: $res")
                    }
                    else {
                        Log.d(TAG, "onResponse: Error Code ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d(TAG, t.message ?: "토큰 정보 등록 중 통신오류")
                }
            })
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            initAuth()
        }

        // FCM 토큰 수신
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "FCM 토큰 얻기에 실패하였습니다.", task.exception)
                return@OnCompleteListener
            }

            // 새로운 FCM 등록 토큰을 얻음
            uploadToken(task.result!!)

            // token log 남기기
            Log.d(TAG, "token: ${task.result ?: "task.result is null"}")
        })

        createNotificationChannel(channel_id, "ssafy")

    }
    @RequiresApi(Build.VERSION_CODES.O)
    // Notification 수신을 위한 채널 추가
    private fun createNotificationChannel(id: String, name: String) {
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(id, name, importance)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
    // firebase authentication 관련
    private var mAuth: FirebaseAuth? = null
    var mGoogleSignInClient: GoogleSignInClient? = null

    // 인증 초기화
    private fun initAuth() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            // default_web_client_id 값은 build 타임에 values.xml 파일에 자동 생성
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail() // 인증 방식: gmail
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        mAuth = FirebaseAuth.getInstance()

        // Google에서 제공되는 signInIntent를 이용해서 인증 시도
        val signInIntent = mGoogleSignInClient!!.signInIntent

        //콜백함수 부르며 launch
        requestActivity.launch(signInIntent)
    }

    // 구글 인증 결과 획득 후 동작 처리
    private val requestActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        Log.d(TAG, "firebaseAuthWithGoogle: Activity.RESULT_OK): ${RESULT_OK}, activityResult.resultCode:${activityResult.resultCode}")
        if (activityResult.resultCode == Activity.RESULT_OK) {

            // 인증 결과 획득
            val task = GoogleSignIn.getSignedInAccountFromIntent(activityResult.data)
            try {
                val account = task.getResult(ApiException::class.java)
                Log.d(TAG, "firebaseAuthWithGoogle: account: ${account}")
                firebaseAuthWithGoogle(account!!.idToken)
            }
            catch (e: ApiException) {
                Log.w(TAG, "google sign in failed: " ,e)
            }
        }
    }

    // 구글 인증 결과 성공 여부에 따른 처리
    private fun firebaseAuthWithGoogle(idToken: String?) {
        Log.d(TAG, "firebaseAuthWithGoogle: idToken: ${idToken}")
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = mAuth!!.currentUser
                    updateUI(user)

                }
                else {
                    updateUI(null)
                }
            }
    }

    // 인증 성공 여부에 따른 화면 처리
    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {

           //Log.d(TAG, "updateUI: 사용자의 사진: ${user.photoUrl}")

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("name", user.displayName)
                putExtra("img", user.photoUrl.toString())
            }
            startActivity(intent)

        }
        else {
            Log.d(TAG, "updateUI: 인증실패")
            Toast.makeText(this, "인증 실패", Toast.LENGTH_LONG).show();
        }
    }
}