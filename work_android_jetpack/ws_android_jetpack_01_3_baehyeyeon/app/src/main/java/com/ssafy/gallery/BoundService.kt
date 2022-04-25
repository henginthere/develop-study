package com.ssafy.gallery

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class BoundService : Service() {
    // 서비스 클라이언트 바인딩 시 반환할 IBinder 객체
    private var myLocalBinder = MyLocalBinder()
    private var photoDao = PhotoDao()

    inner class MyLocalBinder : Binder(){
        fun getService(): BoundService = this@BoundService
    }
    // 서비스 클라이언트 바인딩 시 IBinder 객체 반환
    override fun onBind(intent: Intent?): IBinder {
        return myLocalBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    override fun onCreate() {
        photoDao.dbOpenHelper(this)
        photoDao.open()
        photoDao.create()
        super.onCreate()
    }

    override fun onDestroy() {
        photoDao.close()
        super.onDestroy()
    }


    fun selectAll():MutableList<Photo>{
        return photoDao.selectAllPhotos()
    }


    fun select(num: Int):Photo?{
        return photoDao.selectPhotos(num)
    }

}