package com.ssafy.helloworld

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.ssafy.helloworld.databinding.ActivitySubBinding

private const val TAG = "SubActivity_싸피"
class SubActivity : AppCompatActivity() {

//    //1-1. activity_sub.xml에 존재하는 View 저장하는 필드
//    private lateinit var tvInfo : TextView
//    private lateinit var btnSub : Button

    //1-2.
    private lateinit var binding : ActivitySubBinding //activitysub.xml 내용을 binding 하겠다는 뜻

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)

//        //1-1. activity_sub.xml과 연결한다.
//        setContentView(R.layout.activity_sub)
//        tvInfo = findViewById(R.id.tvInfo)
//        btnSub = findViewById(R.id.btnSub)

        //1-2. viewBinding을 통해 레이아웃의 View 객체들을 가져온다.
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root) //.root는 activity_sub.xml을 뜻한다.

        //2. 전달받은 인텐트에서 extra 정보 확인 후 화면에 출력
        val name = intent.getStringExtra("name")
        binding.tvInfo.text = name

        //3. 돌아가기 버튼 클릭하면 MainActivity로 넘어간다.
        binding.btnSub.setOnClickListener{

            //4. MainActivity로 돌아갈 때, 데이터 전달 - 양방향
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("to_main", "잘 받았습니다.")

            //4-1. 결과 전달
            setResult(Activity.RESULT_OK, intent)

            //3-1. SubActivity 종료
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }
}