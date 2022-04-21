package com.ssafy.cleanstore.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.ssafy.cleanstore.dao.StuffDao
import com.ssafy.cleanstore.dto.Stuff

private const val TAG = "BoundService_싸피"
class BoundService : Service() {

    // 서비스 클라이언트 바인딩 시 반환할 IBinder 객체
    private var myLocalBinder = MyLocalBinder()
    private var stuffDao = StuffDao()

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
        stuffDao.dbOpenHelper(this)
        stuffDao.open()
        stuffDao.create()
        super.onCreate()
    }

    override fun onDestroy() {
        stuffDao.close()
        super.onDestroy()
    }

    fun insert(dto: Stuff,context: Context){
        stuffDao.dbOpenHelper(context)
        stuffDao.open()
        return stuffDao.stuffInsert(dto)
    }

    fun selectAll():MutableList<Stuff>{
        return stuffDao.stuffSelectAll()
    }

    fun update(dto: Stuff){
        return stuffDao.stuffUpdate(dto)
    }

    fun delete(id: Int){
        return stuffDao.stuffDelete(id)
    }

    fun select(id: Int):Stuff?{
        return stuffDao.stuffSelect(id)
    }

}


