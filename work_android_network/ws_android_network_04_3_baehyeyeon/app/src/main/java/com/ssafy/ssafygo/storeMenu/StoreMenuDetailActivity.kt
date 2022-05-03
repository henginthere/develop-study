package com.ssafy.ssafygo.storeMenu

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.ssafy.ssafygo.R
import com.ssafy.ssafygo.dto.ReceiptDTO
import com.ssafy.ssafygo.dto.StoreMenuDTO
import com.ssafy.ssafygo.receipt.ReceiptListActivity
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

private const val TAG="StoreMenuDetailActivity_싸피"
class StoreMenuDetailActivity : AppCompatActivity() {

    private lateinit var tvStoreMenuName: TextView
    private lateinit var tvStoreMenuPrice: TextView
    private lateinit var btnOrder: Button

    private lateinit var name: String
    private var price = 0

    private var storeId = 1

    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_menu_detail)

        // name
        tvStoreMenuName = findViewById(R.id.tv_item_name)

        // price
        tvStoreMenuPrice = findViewById(R.id.tv_item_price)

        btnOrder = findViewById(R.id.btn_order)


        val storeMenu = intent.getSerializableExtra("StoreMenu") as StoreMenuDTO

        setMenuDetail(storeMenu)

        btnOrder.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder
                .setMessage("주문하실 메뉴가 '$name' 맞습니까?")
                .setPositiveButton("예",
                    DialogInterface.OnClickListener { dialog, id ->
                        //Log.d(TAG, "onCreate: 예 클릭")
                        val intent = Intent(this, ReceiptListActivity::class.java)
                        val time = System.currentTimeMillis()
                        val simpleDataFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREAN).format(time)
                        val orderMenu = ReceiptDTO(name, price, simpleDataFormat)
                        intent.putExtra("OrderMenu", orderMenu)
                    })
                .setNegativeButton("아니오",
                    DialogInterface.OnClickListener { dialog, id ->
                        finish()
                    })

            val alter = builder.create()
            alter.setTitle("메뉴 주문")
            alter.show()
        }

    }
    // 메뉴 정보 모두 가져오기
    private fun setMenuDetail(storeMenu: StoreMenuDTO?) {
        if (storeMenu != null) {
            name = storeMenu.name
            price = storeMenu.price
            storeId = storeMenu.storeId

            tvStoreMenuName.setText(name)
            tvStoreMenuPrice.setText(price.toString()+"원")
        }
    }
}

