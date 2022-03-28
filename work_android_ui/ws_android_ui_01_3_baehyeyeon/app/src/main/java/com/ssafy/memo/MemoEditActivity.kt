package com.ssafy.memo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.memo.databinding.ActivityMemoEditBinding

private const val TAG = "MainActivity_싸피"

class MemoEditActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMemoEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMemoEditBinding.inflate(layoutInflater)
        setContentView(binding.root) //.root는 activity_sub.xml을 뜻한다.

        binding.save.setOnClickListener{
            val title : String = binding.editTodo.text.toString().trim()
            val content : String = binding.editDetail.text.toString().trim()

            if(title.isEmpty() || content.isEmpty()){
                Toast.makeText(this, "빈 내용이 있습니다.", Toast.LENGTH_SHORT).show()
                Log.d(TAG,"빈칸입력")
            }

            else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("title", title)

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