package com.ssafy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class CollapsingToolbarLayoutActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar_layout)

        toolbar = findViewById(R.id.collapsing_toolbar)
        toolbar.inflateMenu(R.menu.menu_main)
    }
}