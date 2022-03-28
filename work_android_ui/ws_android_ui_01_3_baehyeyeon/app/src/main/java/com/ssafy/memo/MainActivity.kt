package com.ssafy.memo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.ssafy.memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // activity_main.xml과 연결
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //오늘의 주요 메모 등록 버튼을 누르면 MemoEditActivity로 넘어간다
        binding.addMemo.setOnClickListener{
            val intent = Intent(this, MemoEditActivity::class.java)
            subActivityLauncher.launch(intent)
        }

        binding.showMemo.setOnClickListener {
            val intent = Intent(this, MemoInfoActivity::class.java)
            subActivityLauncher.launch(intent)
        }


    }

    private val subActivityLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if(it.resultCode == Activity.RESULT_OK){
            val intent = it.data
            val returnValue = intent!!.getStringExtra("title")
            binding.title.setText(returnValue)
        }

    }
}