package com.ssafy.ui

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

private const val TAG = "SqliteActivity_싸피"
class SqliteActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper
    private lateinit var database: SQLiteDatabase

    private lateinit var btnInsert: Button
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button
    private lateinit var btnSelect: Button
    private lateinit var btnList: Button
    private lateinit var etId: EditText
    private lateinit var etContent: EditText
    private lateinit var tvList: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        dbHelper = DBHelper(this, "newdb.db", null, 1)
        database = dbHelper.writableDatabase
        Log.d(TAG, "onCreate: 생성된 DB 정보: $database")

        btnInsert = findViewById(R.id.btn_insert)
        btnUpdate = findViewById(R.id.btn_update)
        btnDelete = findViewById(R.id.btn_delete)
        btnSelect = findViewById(R.id.btn_search)
        btnList = findViewById(R.id.btn_list)
        etId = findViewById(R.id.et_id)
        etContent = findViewById(R.id.et_content)
        tvList = findViewById(R.id.tv_list)

        btnInsert.setOnClickListener {
            val content = etContent.text.toString()
            dbHelper.insert(content)
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()
            btnList.performClick() // listBtn 을 클릭해서 화면을 갱신함
        }

        btnSelect.setOnClickListener {
            val id = etId.text.toString()

            val result =  dbHelper.select(id)
            etContent.setText( result.get("txt").toString())
        }

        btnUpdate.setOnClickListener {
            val id = etId.text.toString()
            val content = etContent.text.toString()
            dbHelper.update(id, content)
            Toast.makeText(this, "수정되었습니다.", Toast.LENGTH_SHORT).show()

            btnList.performClick()// 수정 완료 후 화면 갱신
        }

        btnDelete.setOnClickListener {
            val id = etId.text.toString()
            dbHelper.delete(id)
            Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show()

            btnList.performClick()// 삭제 완료 후 화면 갱신
        }

        btnList.setOnClickListener {
            val list = dbHelper.list()
            tvList.text = list

            Log.d(TAG, "list: $list")
        }
    }
}