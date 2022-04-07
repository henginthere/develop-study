package com.ssafy.component

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.component.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    lateinit var binding : ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textview.text = "전달받은 데이터 : ${intent.getStringExtra("Key")}"
    }
}