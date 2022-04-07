package com.ssafy.toolbar

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        toolbar.apply{
            title = resources.getString(R.string.app_name)
            background = ColorDrawable(resources.getColor(R.color.purple_200,theme))
            inflateMenu(R.menu.menu_main) //툴바에 정의되어 있는 함수 inflateMenu
        }

    }
}