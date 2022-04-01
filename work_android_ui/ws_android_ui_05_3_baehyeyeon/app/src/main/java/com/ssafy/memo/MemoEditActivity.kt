package com.ssafy.memo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.memo.databinding.ActivityMemoEditBinding
import com.ssafy.memo.util.Utils

class MemoEditActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMemoEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val initTodo = intent.getStringExtra("todo")
        val initDetail = intent.getStringExtra("detail")
        val initTime = intent.getStringExtra("time")
        val index = intent.getIntExtra("num",0)

        binding.todo.setText(initTodo)
        binding.detail.setText(initDetail)
        binding.editTime.setText(initTime)

        //수정모드일 경우 ( 전달받은 initTodo가 비어있지 않으면)
        if(initTodo!!.isNotEmpty()){
            binding.tvTime.visibility = View.VISIBLE
            binding.editTime.visibility = View.VISIBLE
            binding.remove.visibility = View.VISIBLE
            binding.todo.isEnabled = false
            binding.editTime.isEnabled = false
        }

        binding.save.setOnClickListener {
            val newTodo: String = binding.todo.text.toString().trim()
            val newDetail: String = binding.detail.text.toString().trim()
            val newTime = Utils.formatter().format(System.currentTimeMillis())

            if (newTodo.isEmpty() || newDetail.isEmpty()) {
                Toast.makeText(this, "빈 내용이 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("inputTodo", newTodo)
                intent.putExtra("inputDetail", newDetail)
                intent.putExtra("inputTime",newTime)
                intent.putExtra("inputNum",index)

                //등록
                if(initTodo.isEmpty()){
                    intent.putExtra("state",0)
                }
                //수정
                else{
                    intent.putExtra("state",1)
                }
                //4-1. 결과 전달
                setResult(Activity.RESULT_OK, intent)

                //3-1. SubActivity 종료
                finish()
            }
        }
        binding.cancel.setOnClickListener {
            finish()
        }

        binding.remove.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("inputNum",index)
            intent.putExtra("state",2)

            setResult(RESULT_OK,intent)

            finish()
        }
    }

}

