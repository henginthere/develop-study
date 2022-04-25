package com.ssafy.jetpack_01.view_model_ktx.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.jetpack_01.view_model_ktx.R
import com.ssafy.jetpack_01.view_model_ktx.databinding.ActivityWithFragmentBinding

class WithFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWithFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWithFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, BlankFragment1())
            .commit()

        binding.fragment1.setOnClickListener {
            Toast.makeText(this, "Fragment1", Toast.LENGTH_SHORT).show()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, BlankFragment1())
                .commit()
        }

        binding.fragment2.setOnClickListener {
            Toast.makeText(this, "Fragment2", Toast.LENGTH_SHORT).show()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, BlankFragment2())
                .commit()
        }
    }
}