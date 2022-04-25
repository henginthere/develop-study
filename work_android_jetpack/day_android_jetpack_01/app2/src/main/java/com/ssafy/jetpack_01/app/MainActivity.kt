package com.ssafy.jetpack_01.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ssafy.jetpack_01.app.databinding.ActivityMainBinding

// 1. ViewModel 시작. Activity에서 count관리 -> ViewModel로 이전
//    화면회전 대응됨.
// 2. 메모리 부족 등으로 재시작 될 경우는 삭제됨 -> onSavedInstanceState에서 저장하기.
//    ViewModel의 생성자로 초기값을 넣어 입력해야 하므로, ViewModelFactory를 만들어야 함.
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this,
            MainViewModelFactory(savedInstanceState?.getInt(KEY_COUNT) ?: 0)
        )[MainViewModel::class.java]

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.countText.text = viewModel.count.toString()

        // 버튼 클릭 시 카운트 증가
        binding.increaseButton.setOnClickListener {
            viewModel.increaseCount()
            binding.countText.text = viewModel.count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, viewModel.count)
    }

    companion object {
        private const val KEY_COUNT = "count"
    }
}