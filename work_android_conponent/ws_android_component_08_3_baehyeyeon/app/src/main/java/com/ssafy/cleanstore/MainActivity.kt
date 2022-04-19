package com.ssafy.cleanstore

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.tabs.TabLayout
import com.ssafy.cleanstore.databinding.ActivityMainBinding
import com.ssafy.cleanstore.fragment.MainFragment
import com.ssafy.cleanstore.fragment.StoreFragment
import com.ssafy.cleanstore.service.BoundService


private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 1. 네이게이션 호스트 프래그먼트 객체 얻어오기
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host) as NavHostFragment

        // 2. 1번 객체에서 네비게이션 컨트롤러 객체 얻어오기
        val navController = navHostFragment.navController

        // 3. 2번에서 얻은 컨트롤러 객체와 bottomnavigationview 바인딩
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")

        //서비스 바인딩
        if(!MyServiceConnection.isBound){
            Intent(this, BoundService::class.java).also {
                bindService(it, MyServiceConnection, Context.BIND_AUTO_CREATE)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")

        if(MyServiceConnection.isBound){
            //서비스 바인딩 중지
            unbindService(MyServiceConnection)
            MyServiceConnection.isBound=false
        }
    }

}
//서비스가 반환한 바인더 객체를 이용해 서비스에 접속하거나 접속 종료를 처리하는 ServiceConnection 객체를 생성하기 위한 클래스 생성
object MyServiceConnection : ServiceConnection {

    //바인딩 한 서비스 객체
    lateinit var myService: BoundService

    //바인딩 성공여부
    var isBound = false
    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        Log.d(TAG, "onServiceConnected: ")
        val binder = service as BoundService.MyLocalBinder
        myService = binder.getService()
        isBound = true
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        Log.d(TAG, "onServiceDisconnected: ")
        isBound = false
    }


}
