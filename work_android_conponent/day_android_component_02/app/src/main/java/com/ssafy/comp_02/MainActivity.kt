package com.ssafy.comp_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import com.ssafy.comp_02.databinding.ActivityMainBinding
import com.ssafy.comp_02.fragment.AFragment
import com.ssafy.comp_02.fragment.BFragment
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            btnFragmentA.setOnClickListener {
                supportFragmentManager
                    .beginTransaction()
                    .replace(  // fragment 추가, 교체, 삭제 작업 명시
                        R.id.container_fragment,
                        AFragment.newInstance("A Button Clicked", getCurDate())
                    ).commit()

                Log.d(TAG, "onCreate: AFragment로 교체")
            }

            btnFragmentB.setOnClickListener {
                supportFragmentManager
                    .beginTransaction()
                    .replace(  // fragment 추가, 교체, 삭제 작업 명시
                        R.id.container_fragment,
                        BFragment.newInstance("B Button Clicked", getCurDate())
                    ).commit()

                Log.d(TAG, "onCreate: BFragment로 교체")
            }

            btnRemove.setOnClickListener {
                supportFragmentManager.apply {
                    val currentFragment = findFragmentById(R.id.container_fragment)
                    Log.d(TAG, "onCreate: 현재 Fragment: $currentFragment")

                    if (currentFragment != null) {
                        beginTransaction()
                            .remove(currentFragment)
                            .commit()
                    }
                    else {
                        Toast.makeText(this@MainActivity,
                            "제거할 프레그먼트가 없습니다.",
                            Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }

        supportFragmentManager.apply {
            val currentFragment = findFragmentById(R.id.container_fragment)
            Log.d(TAG, "onCreate: 현재 Fragment: $currentFragment")

            if (currentFragment == null) {
                beginTransaction()
                    .add(R.id.container_fragment, AFragment.newInstance("초기설정으로 추가", getCurDate()))
                    .add(R.id.container_fragment, BFragment.newInstance("초기설정으로 추가", getCurDate()))
                    .commit()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState: ")
    }

    fun getCurDate() : String {

        // format 설정
        val format = SimpleDateFormat("yyyy-MM-dd kk:mm:ss E", Locale.KOREAN)

        // TimeZone 설정 (GMT +9)
        format.timeZone = TimeZone.getTimeZone("Asia/Seoul")

        // 현재시간에 적용
        return format.format(Date().time)
    }
}