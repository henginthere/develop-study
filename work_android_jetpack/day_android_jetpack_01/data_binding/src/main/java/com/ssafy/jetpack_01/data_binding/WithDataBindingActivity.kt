package com.ssafy.jetpack_01.data_binding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.ssafy.jetpack_01.data_binding.databinding.ActivityWithDataBindingBinding
import kotlin.random.Random

class WithDataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWithDataBindingBinding

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)

        title = "with Databinding"

        binding = DataBindingUtil.setContentView(this, R.layout.activity_with_data_binding)

        // 혹은 기존방식으로...
//        binding = ActivityWithDataBindingBinding.inflate(layoutInflater)
//        setContentView(binding.root)


        var userList = arrayOf(User("길동", "홍"), User("순신", "이"), User("사임당", "신"))

        binding.activity = this

        binding.nextButton.setOnClickListener {
            var rand =  Random.nextInt(3)
            binding.user = userList[rand]
        }
    }

    // click event 처리.
    fun onButtonClick(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}