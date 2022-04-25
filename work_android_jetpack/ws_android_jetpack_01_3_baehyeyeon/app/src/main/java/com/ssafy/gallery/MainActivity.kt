package com.ssafy.gallery

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log

private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
            MyServiceConnection.isBound =false
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
