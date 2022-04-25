package com.ssafy.jetpack_01.view_model_ktx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ssafy.jetpack_01.view_model_ktx.databinding.ActivityMainBinding
import com.ssafy.jetpack_01.view_model_ktx.fragments.WithFragmentActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // 0.
    //private val viewModel: MainViewModel by viewModels()

    // 1.
    private val viewModelWithParam by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(0) as T
            }
        }).get(MainViewModel::class.java)
    }

    // 2.
//    private val viewModelWithParam2 by viewModels<MainViewModel> {
//        object : ViewModelProvider.Factory {
//            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//                return MainViewModel(0) as T
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.countText.text = viewModelWithParam.count.toString()

        // 버튼 클릭 시 카운트 증가
        binding.increaseButton.setOnClickListener {
            viewModelWithParam.increaseCount()
            binding.countText.text = viewModelWithParam.count.toString()
        }

        binding.button.setOnClickListener {
            startActivity(Intent(this, WithFragmentActivity::class.java))
        }
    }
}