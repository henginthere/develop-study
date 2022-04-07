package com.ssafy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        val edt = findViewById<EditText>(R.id.edt)
        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            Toast.makeText(this, edt.text.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}