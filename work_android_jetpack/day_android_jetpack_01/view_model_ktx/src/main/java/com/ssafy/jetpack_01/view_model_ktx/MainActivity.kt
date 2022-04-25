package com.ssafy.jetpack_01.view_model_ktx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ssafy.jetpack_01.view_model_ktx.databinding.ActivityMainBinding
import com.ssafy.jetpack_01.view_model_ktx.fragments.WithFragmentActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.countText.text = viewModel.count.toString()

        // 버튼 클릭 시 카운트 증가
        binding.increaseButton.setOnClickListener {
            viewModel.increaseCount()
            binding.countText.text = viewModel.count.toString()
        }

        binding.button.setOnClickListener {
            startActivity(Intent(this, WithFragmentActivity::class.java))
        }
    }
}