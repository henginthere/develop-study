package com.ssafy.comp_02.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import com.ssafy.comp_02.fragment.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")

        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            btnAFragment.setOnClickListener{
                supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.container_fragment,
                        AFragment.newInstance("A Button Clicked", getCurDate())
                    ).commit()
            }

            btnBFragment.setOnClickListener{
                supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.container_fragment,
                        BFragment.newInstance("B Button Clicked", getCurDate())
                    ).commit()
            }

            btnRemove.setOnClickListener{
                supportFragmentManager.apply {
                    val current = findFragmentById(R.id.container_fragment)
                    Log.d(TAG, "onCreate: 현재 Fragment: $current")

                    //현재 fragment가 container_fragment에 존재하면
                    if(current != null){
                        beginTransaction()
                            .remove(current)
                            .commit()
                    }

                    else{
                        Toast.makeText(this@MainActivity,
                        "제거할 프레그먼트가 없습니다.",
                        Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }

        supportFragmentManager.apply {
            val current = findFragmentById(R.id.container_fragment)
            Log.d(TAG, "onCreate: 현재 Fragment: $current")

            if(current==null){
                beginTransaction()
                    .add(R.id.container_fragment, AFragment.newInstance("초기값", getCurDate()))
                    .add(R.id.container_fragment,BFragment.newInstance("초기값", getCurDate()))
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

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(TAG, "onSaveInstanceState: ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState: ")
    }

    fun getCurDate(): String {
        //format 설정
        val format = SimpleDateFormat("yyyy-MM-dd kk:mm:ss E", Locale.KOREAN)

        //TimeZone 설정 (GMT +9)
        format.timeZone = TimeZone.getTimeZone("Asia/Seoul")

        //현재 시간에 적용
        return format.format(Date().time)
    }

}