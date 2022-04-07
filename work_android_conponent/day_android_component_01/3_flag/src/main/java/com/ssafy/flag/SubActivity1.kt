package com.ssafy.flag

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.flag.databinding.ActivitySub1Binding

private const val TAG = "SubActivity1_싸피"

class SubActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivitySub1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySub1Binding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnWeb.setOnClickListener {
            startActivity(Intent(Intent.ACTION_WEB_SEARCH))
        }
        binding.btnCallSub2NewTask.setOnClickListener {
            val intent = Intent(this, SubActivity2::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
        }
        binding.btnCallSub2.setOnClickListener {
            startActivity(Intent(this, SubActivity2::class.java))
        }
        Log.d(TAG, "onCreate: ${System.identityHashCode(this)}")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ${System.identityHashCode(this)}")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ${System.identityHashCode(this)}")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ${System.identityHashCode(this)}")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ${System.identityHashCode(this)}")
    }
}
