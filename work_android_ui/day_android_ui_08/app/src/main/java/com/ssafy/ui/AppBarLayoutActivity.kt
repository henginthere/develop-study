package com.ssafy.ui

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar

class AppBarLayoutActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar_layout)

        toolbar = findViewById(R.id.toolbar_layout)
        toolbar.apply {
            title = "레이아웃 테스트"
            background = ColorDrawable(resources.getColor(R.color.teal_200, theme))
        }

        findViewById<Button>(R.id.collapsing_btn).setOnClickListener {
            startActivity(Intent(this, CollapsingToolbarLayoutActivity::class.java))
        }
    }
}