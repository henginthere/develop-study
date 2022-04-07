package com.ssafy.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_0).setOnClickListener {
            var intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_1).setOnClickListener {
            var intent = Intent(this, MotionLayoutActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_2).setOnClickListener {
            var intent = Intent(this, CardViewActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_3).setOnClickListener {
            var intent = Intent(this, PreferenceActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_4).setOnClickListener {
            var intent = Intent(this, MyFileOutActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button_5).setOnClickListener {
            var intent = Intent(this, SqliteActivity::class.java)
            startActivity(intent)
        }
    }
}