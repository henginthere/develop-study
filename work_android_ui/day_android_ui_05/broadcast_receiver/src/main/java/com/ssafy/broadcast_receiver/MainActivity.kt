package com.ssafy.broadcast_receiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {

    private lateinit var btnBroadcast1: Button
    private lateinit var btnBroadcast2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBroadcast1 = findViewById(R.id.btn_broadcast1)
        btnBroadcast1.setOnClickListener { 
            val intent = Intent("com.ssafy.android.news.funny")
            intent.putExtra("content", "티끌은 모아도 티끌이다.")
            
            // permission 사용자 대상으로 broadcast 발송
            sendBroadcast(intent, "com.ssafy.android.news.funny.PRIVATE")
            Log.d(TAG, "onCreate: 발송 완료")
        }

        btnBroadcast2 = findViewById(R.id.btn_broadcast2)
        btnBroadcast2.setOnClickListener {
            var intent = Intent(this, BroadcastActivity::class.java)
            startActivity(intent)
        }
    }
}