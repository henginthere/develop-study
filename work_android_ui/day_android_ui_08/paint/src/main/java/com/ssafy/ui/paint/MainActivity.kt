package com.ssafy.ui.paint

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ssafy.ui.paint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRed.setOnClickListener {
            binding.draw.mColor = Color.RED
        }

        binding.buttonGreen.setOnClickListener {
            binding.draw.mColor = Color.GREEN
        }

        binding.buttonBlue.setOnClickListener {
            binding.draw.mColor = Color.BLUE
        }

        binding.buttonClear.setOnClickListener {
            binding.draw.clear()
        }
    }
}