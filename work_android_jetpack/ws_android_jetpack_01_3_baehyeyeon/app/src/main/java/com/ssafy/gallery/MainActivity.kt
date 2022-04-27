package com.ssafy.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.ssafy.gallery.databinding.ActivityMainBinding

private const val TAG = "MainActivity_싸피"

class MainActivity : AppCompatActivity(), GalleryFragment.Callbacks {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Log.d(TAG, "onCreate: ")
        //초기 화면 설정
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment==null){
            val fragment = GalleryFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }

    }
    //리사이클러 뷰 클릭시
    override fun onPhotoSelected(photoId: Int) {
        // Fragment에 인자 전달하기
        val fragment = PhotoFragment.newInstance(photoId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}