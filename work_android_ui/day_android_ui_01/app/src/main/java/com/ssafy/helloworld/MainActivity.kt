package com.ssafy.helloworld

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.ssafy.helloworld.databinding.ActivityMainBinding

//const val은 java의 static final과 같다.
private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {

    //1-1.
    //private lateinit var clickMe : Button

    //1-2.
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        Log.d(TAG, "onCreate: ") //d: debug를 뜻한다. debug 내부에서만 찍히는 log라고 생각하면 된다.
        
//        //1-1. activity_main.xml과 연결한다.
//        setContentView(R.layout.activity_main)
//        clickMe = findViewById(R.id.clickMe) //R : res 폴더

        //1-2.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //2. Hello World 버튼을 누르면 SubActivity로 넘어간다.
        binding.clickMe.setOnClickListener{

            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("name","ssafy")

            //2-1. Intent를 통해 SubActivity 호출 - 단방향
            //startActivity(intent)

            //2-2. Intent를 통해 SubActivity 호출 - 양방향
            subActivityLauncher.launch(intent)

        }
    }

    private val subActivityLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if(it.resultCode == Activity.RESULT_OK){
            val intent = it.data
            val returnValue = intent!!.getStringExtra("to_main")
            Toast.makeText(this, returnValue, Toast.LENGTH_SHORT).show()
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