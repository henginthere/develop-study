package com.ssafy.ssafygo.storeMenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.ssafy.ssafygo.R
import com.ssafy.ssafygo.dto.StoreMenuDTO


class StoreMenuDetailActivity : AppCompatActivity() {

    private lateinit var tvStoreMenuName: TextView
    private lateinit var tvStoreMenuPrice: TextView

    private var storeId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_menu_detail)

        // name
        tvStoreMenuName = findViewById(R.id.tv_item_name)

        // price
        tvStoreMenuPrice = findViewById(R.id.tv_item_price)


        val storeMenu = intent.getSerializableExtra("StoreMenu") as StoreMenuDTO

        setStoreMenu(storeMenu)

    }

    private fun setStoreMenu(storeMenu: StoreMenuDTO?) {
        if (storeMenu != null) {
            val name: String = storeMenu.item
            val price = storeMenu.price
            storeId = storeMenu.storeId

            // 리뷰의 내용과 점수
            tvStoreMenuName.setText(name)
            tvStoreMenuPrice.setText(price.toString())
        }
    }
}

