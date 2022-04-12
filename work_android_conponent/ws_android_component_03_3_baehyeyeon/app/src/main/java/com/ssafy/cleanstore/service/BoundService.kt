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
    private lateinit var myLocalBinder: IBinder
    private var stuffDao = StuffDao()

    // 서비스 클라이언트 바인딩 시 IBinder 객체 반환
   override fun onBind(intent: Intent): IBinder {
        Log.d(TAG, "onBind: ")
        myLocalBinder = MyLocalBinder()
        return myLocalBinder
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

}

class MyLocalBinder : Binder(){
    fun getService(): BoundService = BoundService()
}
