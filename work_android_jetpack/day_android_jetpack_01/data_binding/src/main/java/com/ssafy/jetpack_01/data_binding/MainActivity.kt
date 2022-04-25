package com.ssafy.jetpack_01.data_binding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ssafy.jetpack_01.data_binding.databinding.ActivityMainBinding
import kotlin.random.Random

// 데이터바인딩 사용 전 코드
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "no Databinding"

        var userList = arrayOf(User("길동", "홍"), User("순신", "이"), User("사임당", "신"))

        binding.nextButton.setOnClickListener {
            var rand = Random.nextInt(3)
            binding.firstnameTextView.text = userList[rand].firstName
            binding.lastnameTextView.text = userList[rand].lastName
        }

        binding.button.setOnClickListener {
            startActivity(Intent(this, WithDataBindingActivity::class.java))
        }
    }
}