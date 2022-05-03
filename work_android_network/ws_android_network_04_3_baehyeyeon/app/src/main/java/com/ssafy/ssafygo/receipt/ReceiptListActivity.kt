package com.ssafy.ssafygo.receipt

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.ssafy.ssafygo.R
import com.ssafy.ssafygo.databinding.ActivityReceiptListBinding
import com.ssafy.ssafygo.dto.ReceiptDTO
import com.ssafy.ssafygo.dto.StoreMenuDTO
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

private const val TAG="ReceiptListActivity_싸피"

class ReceiptListActivity : AppCompatActivity() {


    private var receiptList: ArrayList<ReceiptDTO> = arrayListOf()
    private lateinit var adapter: ArrayAdapter<ReceiptDTO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt_list)
        val listview: ListView = findViewById(R.id.listview_store_menu)

        // Adapter와 ListView 연결
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, receiptList)
        listview.adapter = adapter

        val orderMenu = intent.getSerializableExtra("orderMenu") as ReceiptDTO
        Log.d(TAG, "onCreate: ${orderMenu.time}")
        setReceiptList()

        val btnWriteReceipt:Button = findViewById(R.id.btn_write_receipt)
        btnWriteReceipt.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder
                .setMessage("주문내용을 저장할 NFC를 태깅해주세요.")

                .setNegativeButton("취소",
                    DialogInterface.OnClickListener { dialog, id ->
                        finish()
                    })

            val alter = builder.create()
            alter.setTitle("마지막 주문내용 저장")
            alter.show()
        }
        
    }

    private fun setReceiptList(){
        val lastOrder = intent.getSerializableExtra("orderMenu") as ReceiptDTO
        receiptList.add(lastOrder)
    }
}