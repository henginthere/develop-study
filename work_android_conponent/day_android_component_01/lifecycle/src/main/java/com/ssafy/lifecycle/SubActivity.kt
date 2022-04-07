package com.ssafy.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.lifecycle.databinding.ActivitySubBinding

private const val TAG ="SubActivity_싸피"
class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")

        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCount.text = counter.toString()

        binding.btnMinus.setOnClickListener {
            counter--
            binding.tvCount.text = counter.toString()
        }

        binding.btnPlus.setOnClickListener {
            counter++
            binding.tvCount.text = counter.toString()
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
        Log.d(TAG, "onSaveInstanceState: counter $counter 값 저장")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        var temp = savedInstanceState.getInt("counter")
        counter = temp
        binding.tvCount.text = counter.toString()
    }
}