package com.ssafy.flag

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.flag.databinding.ActivityMainBinding

private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCallSub1.setOnClickListener {
            val intent = Intent(this, SubActivity1::class.java)
            startActivity(intent)

//            val intent = Intent(this, SubActivity1::class.java).apply {
//                flags = Intent.FLAG_ACTIVITY_NO_HISTORY
//            }
//            startActivity(intent)

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