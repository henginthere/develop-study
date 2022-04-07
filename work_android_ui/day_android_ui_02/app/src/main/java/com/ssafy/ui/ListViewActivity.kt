package com.ssafy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView

private const val TAG = "ListViewActivity_싸피"
class ListViewActivity : AppCompatActivity() {

    private val strData = mutableListOf<String>() //new ArrayList<String<>();
    private val mapData = mutableListOf<Map<String, String>>()

    private lateinit var listView1: ListView
    private lateinit var listView2: ListView
    private lateinit var listView3: ListView
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        tvResult = findViewById(R.id.tvResult)


        // 리스트에 출력할 데이터 생성
        for (i in 1..10) {
            strData.add("data $i")
            mapData.add(mapOf("id" to "hong $i", "name" to "홍길동 $i"))
        }

        // 1. 리스트 1 : 데이터 한 줄
        listView1 = findViewById(R.id.listView1)

        // Adapter 객체 생성
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, strData)

        // Adapter와 ListView 연결
        listView1.adapter = adapter1

        listView1.setOnItemClickListener { parent, view, position, id ->
            tvResult.text = parent.adapter.getItem(position).toString()
            Log.d(TAG, "onCreate: ${ parent.adapter.getItem(position) }")
        }

        // 2. 리스트 2 : 데이터 두 줄
        listView2 = findViewById(R.id.listView2)
        val adapter2 = SimpleAdapter(this, mapData, android.R.layout.simple_list_item_2, arrayOf("id", "name"), intArrayOf(android.R.id.text1, android.R.id.text2))
        listView2.adapter = adapter2
        listView2.setOnItemClickListener { parent, view, position, id ->
            tvResult.text = parent.adapter.getItem(position).toString()
            Log.d(TAG, "onCreate: ${ parent.adapter.getItem(position) }")
        }

        // 3. 리스트 3 : 커스텀 항목
        listView3 = findViewById(R.id.listView3)
        val adapter3 = CustomListAdapter(this, mapData, R.layout.list_item_layout)
        listView3.adapter = adapter3
        listView3.setOnItemClickListener { parent, view, position, id ->
            tvResult.text = parent.adapter.getItem(position).toString()
            Log.d(TAG, "onCreate: ${ parent.adapter.getItem(position) }")
        }

    }
}