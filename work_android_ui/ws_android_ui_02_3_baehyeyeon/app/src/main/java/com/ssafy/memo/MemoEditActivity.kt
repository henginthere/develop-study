package com.ssafy.memo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.memo.databinding.ActivityMemoEditBinding

class MemoEditActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMemoEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val initTodo = intent.getStringExtra("todo")
        val initTime = intent.getStringExtra("time")


        binding = ActivityMemoEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.todo.setText(initTodo)
        binding.time.setText(initTime)
        binding.save.setOnClickListener {
            val todo: String = binding.todo.text.toString().trim()
            val detail: String = binding.detail.text.toString().trim()

            if (todo.isEmpty() || detail.isEmpty()) {
                Toast.makeText(this, "빈 내용이 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("inputTodo", todo)
                intent.putExtra("inputDetail", detail)

                //4-1. 결과 전달
                setResult(Activity.RESULT_OK, intent)

                //3-1. SubActivity 종료
                finish()
            }
        }
        binding.cancel.setOnClickListener {
            finish()
        }
    }

}

