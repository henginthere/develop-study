package com.ssafy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        val btn1: Button = findViewById(R.id.button1)

        btn1.setOnClickListener { v: View? ->
            Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
        }
        //View 생략 가능하다
        btn1.setOnClickListener { v ->
            Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
        }
        //파라미터가 하나일 경우에는 파라미터도 지우고 사용가능하다. it이라는 변수가 v를 대신해서 사용 가능
        btn1.setOnClickListener {
            Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
        }
        //it에 들어간 자바클래스 이름을 확인해본다. 결국 it은 button 객체를 뜻한다.
        btn1.setOnClickListener {
            Toast.makeText(this, "Hello World" + it.javaClass.name, Toast.LENGTH_SHORT).show()
        }
    }
}