package com.ssafy.component

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ssafy.component.databinding.ActivityDetailBinding

private const val TAG = "DetailActivity_싸피"
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var value: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = value.toString()

        binding.plus.setOnClickListener {
            value++
            binding.textView.text = value.toString()
        }

        binding.minus.setOnClickListener {
            value--
            binding.textView.text = value.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("value", value)
        Log.d(TAG, "onSaveInstanceState: value: $value 저장")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        value = savedInstanceState.getInt("value")
        Log.d(TAG, "onRestoreInstanceState: value: $value 복구")
        binding.textView.text = value.toString()
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

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent: ")
    }
}