package com.ssafy.music.myservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {

    private lateinit var btnStart: Button
    private lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "서비스 테스트 예제"
        intent = Intent(this, MyMusicService::class.java)
        btnStart = findViewById(R.id.btn_start_music)
        btnStop = findViewById(R.id.btn_stop_music)

        btnStart.setOnClickListener {
            startService(intent)
            Log.d(TAG, "onCreate: startService()")
        }

        btnStop.setOnClickListener {
            stopService(intent);
            Log.d(TAG, "onCreate: StopService()")
        }
    }
}