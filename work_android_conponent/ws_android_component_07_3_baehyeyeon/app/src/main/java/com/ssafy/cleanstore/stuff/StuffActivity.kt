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
import com.ssafy.cleanstore.MyServiceConnection
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
            intent.putExtra("inputStuff",Stuff("",0,""))
            stuffEditActivityLauncher.launch(intent)
        }

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            intent.putExtra("inputStuff",Stuff(items[position].itemName,items[position].itemCnt,items[position].regDate))
            intent.putExtra("inputId", items[position].id)
            Log.d(TAG, "onCreate: ${items[position].id}")
            stuffEditActivityLauncher.launch(intent)
        }

    }


    //리스트 초기화
    private fun setList() {
        //새 리스트 만들기
        //itemList = arrayListOf()
        //Log.d(TAG, "setList: ????????????")
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
            //Log.d(TAG, ":데이터 전달 됐음!!!!!!!!!!! ")
            val state =intent!!.getIntExtra("state",0)

            when(state){

                0->{
                    val returnStuff = intent?.getSerializableExtra("inputStuff") as Stuff
                    val tmpItem = Stuff(returnStuff.itemName, returnStuff.itemCnt, returnStuff.regDate)
                    MyServiceConnection.myService.insert(tmpItem,this)
                }
                1->{
                    val returnStuff = intent?.getSerializableExtra("inputStuff") as Stuff
                    val index = intent!!.getIntExtra("inputId",0)
                    val updateItem = Stuff(index, returnStuff.itemName, returnStuff.itemCnt, returnStuff.regDate)
                    MyServiceConnection.myService.update(updateItem)
                }
                2->{
                    val index = intent!!.getIntExtra("inputId",0)
                    MyServiceConnection.myService.delete(index)
                }
            }
            setList()
        }

    }

}

