package com.ssafy.memo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {

    private val memoList = mutableListOf<String>()
    private lateinit var listView: ListView
    private lateinit var addButton: Button

 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val memoItemMgr = MemoItemMgr()
        memoItemMgr.add(MemoItem("메모앱만들기1", "메모 앱 서로 연결하기", "2021/05/19 03:19"))
        memoItemMgr.add(MemoItem("메모앱만들기2", "메모 앱 UI 만들기", "2021/05/20 05:22"))
        memoItemMgr.add(MemoItem("메모앱만들기3", "메모 앱 설계하기", "2021/05/21 10:30"))

       val n = memoItemMgr.size()
        for(i in 0..2) {
             var tmp = memoItemMgr.getList()[i].title +" " + memoItemMgr.getList()[i].date
             memoList.add(tmp)
        }

        listView = findViewById(R.id.listView)
        addButton = findViewById(R.id.btnAddMemo)

        // Adapter 객체 생성
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, memoList)

        // Adapter와 ListView 연결
        listView.adapter = adapter

     listView.setOnItemClickListener { parent, view, position, id ->
         val intent = Intent(this, MemoEditActivity::class.java)
         val todo = parent.adapter.getItem(position).toString().split(" ")
         intent.putExtra("todo", todo[0])
         intent.putExtra("time", todo[1]+" "+todo[2])
         Log.d(TAG, "onCreate: "+todo[0])

         subActivityLauncher.launch(intent)

     }

     addButton.setOnClickListener {
         val intent = Intent(this, MemoEditActivity::class.java)
         startActivity(intent)
     }



    }
//    private val subActivityLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()
//    ){
//        if(it.resultCode == Activity.RESULT_OK){
//            val intent = it.data
//            val returnTodo = intent!!.getStringExtra("inputTodo")
//            val returnDetail = intent!!.getStringExtra("inputDetail")
//            Log.d(TAG, returnTodo+" "+returnDetail)
//            //binding.title.setText(returnValue)
//        }
//
//    }

private val subActivityLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if(it.resultCode == Activity.RESULT_OK){
            val intent = it.data
            val returnTodo = intent!!.getStringExtra("inputTodo")
            val returnDetail = intent!!.getStringExtra("inputDetail")
            Log.d(TAG, returnTodo+" "+returnDetail)
            //binding.title.setText(returnValue)
        }

    }
}