package com.ssafy.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ssafy.memo.databinding.ActivityMemoEditBinding
import com.ssafy.memo.databinding.ActivityMemoInfoBinding

class MemoInfoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMemoInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMemoInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editMemo1.setText("메모 앱 만들기1 2022-03-28")
        binding.editMemo2.setText("메모 앱 만들기2 2022-03-29")
        binding.editMemo3.setText("메모 앱 만들기3 2022-03-30")

       binding.back.setOnClickListener {
           finish()
       }
    }
}