package com.ssafy.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.ssafy.gallery.databinding.ActivityMainBinding

private const val TAG = "MainActivity_싸피"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Log.d(TAG, "onCreate: ")
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fcv_main, GalleryFragment())
            .commit()
    }
}