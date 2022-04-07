package com.ssafy.ui

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar

class ToolbarActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    @RequiresApi(Build.VERSION_CODES.M)  // getColor 함수는 SDK 23부터 사용가능
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        toolbar = findViewById(R.id.toolbar)
        toolbar.apply {
            title = resources.getString(R.string.app_name)
            background = ColorDrawable(resources.getColor(R.color.teal_200, theme))
            inflateMenu(R.menu.menu_main)
        }

        findViewById<Button>(R.id.btn_layout).setOnClickListener {
            startActivity(Intent(this, AppBarLayoutActivity::class.java))
        }
    }
}