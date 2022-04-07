package com.ssafy.ui

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import java.util.*

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val tv1 = findViewById<TextView>(R.id.tv1)

        // 1. 기본 다이얼로그
        btn1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("기본 다이얼로그")
            builder.setMessage("기본 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            // 버튼 클릭시에 무슨 작업을 할 것인가!
            val listener = DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE ->
                        tv1.text = "BUTTON_POSITIVE"
                    DialogInterface.BUTTON_NEUTRAL ->
                        tv1.text = "BUTTON_NEUTRAL"
                    DialogInterface.BUTTON_NEGATIVE ->
                        tv1.text = "BUTTON_NEGATIVE"
                }
            }
            builder.setPositiveButton("Positive", listener)
            builder.setNegativeButton("Negative", listener)
            builder.setNeutralButton("Neutral", listener)
            builder.show()
        }

        // 2. 커스텀 다이얼로그
        btn2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            val v1 = layoutInflater.inflate(R.layout.dialog, null)
            builder.setView(v1)
            // p0에 해당 AlertDialog가 들어온다. findViewById를 통해 view를 가져와서 사용
            val listener = DialogInterface.OnClickListener { dialog, which ->
                val alert = dialog as AlertDialog
                val edit1: EditText = alert.findViewById(R.id.editText)
                val edit2: EditText = alert.findViewById(R.id.editText2)

                tv1.text = "${edit1.text}"
                tv1.append("${edit2.text}")
            }
            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소", null)
            builder.show()
        }

        // 3. 날짜 다이얼로그
        btn3.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val listener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                tv1.text = "${year}년 ${month + 1}월 ${dayOfMonth}일"
            }

            val picker = DatePickerDialog(this, listener, year, month, day)
            picker.show()
        }


        // 4. 시간 다이얼로그
        btn4.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR)
            val minute = calendar.get(Calendar.MINUTE)

            val listener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                tv1.text = "${hourOfDay}시 ${minute}분"
            }

            // true하면 24시간제
            val picker = TimePickerDialog(this, listener, hour, minute, false)
            picker.show()
        }
    }
}