package com.ssafy.cleanstore.stuff

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.ssafy.cleanstore.databinding.ActivityStuffEditBinding
import com.ssafy.cleanstore.dto.Stuff

private const val TAG = "StuffEditActivity_싸피"

class StuffEditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStuffEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: ")

        val initStuff = intent.getSerializableExtra("inputStuff") as Stuff
        //val initItemName = intent.getStringExtra("inputItemName")
        //val initItemCnt = intent.getIntExtra("inputItemCount",0)
        val index = intent.getIntExtra("inputId",0)

//        binding.itemName.setText(initItemName)
//        binding.itemCnt.setText(initItemCnt.toString())
        binding.itemName.setText(initStuff.itemName)
        binding.itemCnt.setText(initStuff.itemCnt.toString())

        //수정모드일 때 삭제버튼 보인다
        if(initStuff.itemName!!.isNotEmpty()){
            binding.btnDelete.visibility = View.VISIBLE
        }

        //저장 버튼 눌렀을 때
        binding.btnSave.setOnClickListener {
            val newName: String = binding.itemName.text.toString().trim()
            val newCnt: Int = binding.itemCnt.text.toString().trim().toInt()
            Log.d(TAG, "onCreate: 저장버튼 누름")
            if (newName.isEmpty()) {
                Toast.makeText(this, "빈 내용이 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, StuffActivity::class.java)
                intent.putExtra("inputStuff", Stuff(newName, newCnt))
//                intent.putExtra("inputItemName", newName)
//                intent.putExtra("inputItemCount", newCnt)
                intent.putExtra("inputId",index)
                println(newName)

                //등록
                if(initStuff.itemName.isEmpty()){
                    intent.putExtra("state",0)
                }
                //수정
                else{
                    intent.putExtra("inputId", index)
                    intent.putExtra("state",1)
                }

                Log.d(TAG, "onCreate: 값 입력완료")

                setResult(Activity.RESULT_OK, intent)

                finish()
            }

        }

        binding.btnCancel.setOnClickListener {
            Log.d(TAG, "onCreate: 취소")
            finish()
        }

        binding.btnDelete.setOnClickListener {
            Log.d(TAG, "onCreate: 삭제 버튼 누름")
            val intent = Intent(this, StuffActivity::class.java)
            intent.putExtra("inputStuff", Stuff("", 0))
            intent.putExtra("inputId",index)
            intent.putExtra("state",2)

            setResult(RESULT_OK,intent)

            finish()
        }
    }

}