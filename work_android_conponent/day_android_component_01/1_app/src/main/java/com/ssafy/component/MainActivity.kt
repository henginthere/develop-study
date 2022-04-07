package com.ssafy.component

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ssafy.component.databinding.ActivityMainBinding

private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailButton.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        binding.explicitButton.setOnClickListener {
            Toast.makeText(this,"명시적 인텐트", Toast.LENGTH_SHORT).show()

            // 방법 1.
            val intent = Intent(this, NextActivity::class.java)

            // 방법 2.
//            val intent = Intent()
//            val component = ComponentName(
//                "com.ssafy.component",
//                "com.ssafy.component.NextActivity")
//            intent.component = component

            intent.putExtra("Key", "MainActiviy에서 명시적 인텐트 전달")
            startActivity(intent)
        }

        binding.implicitButton.setOnClickListener {
            Toast.makeText(this,"암시적 인텐트", Toast.LENGTH_SHORT).show()

            // 암시적 인텐트 목적에 맞는 호출 : 지도보기, 연락처보기, 인터넷, SNS 공유 등등.
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"))
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            /* activity singleTask에서 외부 애플리케이션에서 호출할 경우에 아래코드 사용하여 호출
            singleTask설명부분. ppt p.53 */
//            var intent = Intent()
//            var name = ComponentName("com.ssafy.banking", "com.ssafy.banking.Banking2Account")
//            intent.setComponent(name)
//
//            startActivity(intent)

            startActivity(Intent(this, PhoneActivity::class.java))
        }
        Log.d(TAG, "onCreate: ")
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