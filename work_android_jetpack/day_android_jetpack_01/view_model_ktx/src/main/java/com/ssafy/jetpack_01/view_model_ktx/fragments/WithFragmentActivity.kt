package com.ssafy.jetpack_01.view_model_ktx.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ssafy.jetpack_01.view_model_ktx.R
import com.ssafy.jetpack_01.view_model_ktx.databinding.ActivityWithFragmentBinding

class WithFragmentActivity : AppCompatActivity(), CommunicationCallback {

    private var count = 0
    private lateinit var binding: ActivityWithFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWithFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, BlankFragment1().apply {
                listener = this@WithFragmentActivity
            }).commit()

        binding.fragment1.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, BlankFragment1().apply {
                    listener = this@WithFragmentActivity
                }).commit()
        }

        binding.fragment2.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, BlankFragment2().apply {
                    listener = this@WithFragmentActivity
                }).commit()
        }
    }

    override fun increaseCount() {
        count++
    }

    override fun decreaseCount() {
        count--
    }

    override fun getCount(): Int {
        return count
    }
}