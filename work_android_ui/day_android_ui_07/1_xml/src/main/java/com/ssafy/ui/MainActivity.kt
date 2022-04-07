package com.ssafy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.ssafy.userinterface_3.Member
import com.ssafy.userinterface_3.MyAddressParser

private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {

    private lateinit var btnLoad: Button
    private lateinit var tvStatus: TextView

    private lateinit var members: List<Member>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLoad = findViewById(R.id.btn_load)
        tvStatus = findViewById(R.id.tv_status)

        btnLoad.setOnClickListener {
            try {
                members = MyAddressParser().parse(assets.open("address.xml"))
                tvStatus.text = members.fold("") { accumulate, new ->
                    """$accumulate
                            |이름: ${new.name} 
                            |전화번호: ${new.phone}
                            |
                            |""".trimMargin()
                }
            }
            catch (e: Exception) {
                Log.e(TAG, "onCreate: assets 파일 로딩 실패", e)
            }
        }
    }
}