package com.ssafy.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.appbar.CollapsingToolbarLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_1).setOnClickListener{
            var intent = Intent(this, ToolbarActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_2).setOnClickListener{
            var intent = Intent(this, AppBarLayoutActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_3).setOnClickListener{
            var intent = Intent(this, CollapsingToolbarLayoutActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_4).setOnClickListener{
            var intent = Intent(this, CustomViewActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_5).setOnClickListener{
            var intent = Intent(this, EffectActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_6).setOnClickListener{
            var intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }
}