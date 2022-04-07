package com.ssafy.cleanstore

import android.R
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.cleanstore.databinding.ActivityMainBinding
import com.ssafy.cleanstore.databinding.ActivityStuffBinding

private const val TAG = "StuffActivity_싸피"
class StuffActivity : AppCompatActivity() {

    private var items = mutableListOf<Stuff>()
    private lateinit var itemList: ArrayList<String>

    private lateinit var binding: ActivityStuffBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffBinding.inflate(layoutInflater)
        setContentView(binding.root)

        items.add(Stuff("사과",10))
        items.add(Stuff("참외",11))

        setList()

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
    //리스트 초기화
    private fun setList() {
        //새 리스트 만들기
        itemList = arrayListOf()

        for (i: Int in 0 until items.size) {
            val itemName = items[i].itemName
            val itemCnt = items[i].itemCnt
            itemList.add("물품 : $itemName -> 수량 : $itemCnt")
        }

        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, itemList)

        //ListView와 adapter 연결
        binding.listView.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    private val stuffEditActivityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val intent = it.data

            val returnItemName = intent!!.getStringExtra("inputItemName").toString()
            val returnItemCount = intent!!.getIntExtra("inputItemCount",0)
            val index = intent!!.getIntExtra("inputIndex",0)
            val state =intent!!.getIntExtra("state",0)


            val tmpItem = Stuff(returnItemName, returnItemCount)
            when(state){
                0->items.add(tmpItem)
                1->items[index] = tmpItem
                2->items.removeAt(index)
            }
            setList()
        }

    }



}