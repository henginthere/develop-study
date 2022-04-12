package com.ssafy.cleanstore.stuff

import android.R
import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.cleanstore.dao.StuffDao
import com.ssafy.cleanstore.databinding.ActivityStuffBinding
import com.ssafy.cleanstore.dto.Stuff
import com.ssafy.cleanstore.service.BoundService
import com.ssafy.cleanstore.service.MyLocalBinder

private const val TAG = "StuffActivity_싸피"
class StuffActivity : AppCompatActivity() {

    private var items = mutableListOf<Stuff>()
    //private lateinit var itemList: ArrayList<String>

    private lateinit var binding: ActivityStuffBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)
        binding = ActivityStuffBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, StuffEditActivity::class.java)

        binding.btnAdd.setOnClickListener {
            intent.putExtra("inputItemName", "")
            intent.putExtra("inputItemCount", 0)
            intent.putExtra("num", -1)
            stuffEditActivityLauncher.launch(intent)
        }

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            intent.putExtra("inputItemName", items[position].itemName)
            intent.putExtra("inputItemCount", items[position].itemCnt)
            intent.putExtra("num", position)

            stuffEditActivityLauncher.launch(intent)
        }

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

    //리스트 초기화
    private fun setList() {
        //새 리스트 만들기
        //itemList = arrayListOf()
        Log.d(TAG, "setList: ????????????")
        items = MyServiceConnection.myService.selectAll();


        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, items)

        //ListView와 adapter 연결
        binding.listView.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    private val stuffEditActivityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val intent = it.data
            Log.d(TAG, ":데이터 전달 됐음!!!!!!!!!!! ")
            val returnItemName = intent!!.getStringExtra("inputItemName").toString()
            val returnItemCount = intent!!.getIntExtra("inputItemCount",0)
            val index = intent!!.getIntExtra("inputIndex",0)
            val state =intent!!.getIntExtra("state",0)


            val tmpItem = Stuff(returnItemName, returnItemCount)
            when(state){
//                0->items.add(tmpItem)
//                1->items[index] = tmpItem
//                2->items.removeAt(index)
                0->MyServiceConnection.myService.insert(tmpItem,this)
                1->MyServiceConnection.myService.update(tmpItem)
                2->MyServiceConnection.myService.delete(index)
            }
            setList()
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
        val binder = service as MyLocalBinder
        myService = binder.getService()
        isBound = true
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        Log.d(TAG, "onServiceDisconnected: ")
        isBound = false
    }


}