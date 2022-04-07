package com.ssafy.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ssafy.ui.basic.BasicRecyclerViewActivity
import com.ssafy.ui.grid.GridRecyclerViewActivity
import com.ssafy.ui.hori.HorizontalRecyclerViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.vertical_btn).setOnClickListener {
            startActivity(Intent(this, BasicRecyclerViewActivity::class.java))
        }

        findViewById<Button>(R.id.horizontal_btn).setOnClickListener {
            startActivity(Intent(this, HorizontalRecyclerViewActivity::class.java))
        }

        findViewById<Button>(R.id.grid_btn).setOnClickListener {
            startActivity(Intent(this, GridRecyclerViewActivity::class.java))
        }
    }
}