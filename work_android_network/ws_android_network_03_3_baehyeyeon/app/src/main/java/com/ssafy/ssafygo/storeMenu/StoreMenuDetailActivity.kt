package com.ssafy.ssafygo.storeMenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.ssafy.ssafygo.ApplicationClass
import com.ssafy.ssafygo.R
import com.ssafy.ssafygo.dto.StoreMenuDTO
import com.ssafy.ssafygo.service.StoreMenuService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG="StoreMenuDetailActivity_싸피"
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

        setMenuDetail(storeMenu)

    }
    // 메뉴 정보 모두 가져오기
    private fun setMenuDetail(storeMenu: StoreMenuDTO?) {
        if (storeMenu != null) {
            val name: String = storeMenu.name
            val price = storeMenu.price
            storeId = storeMenu.storeId

            tvStoreMenuName.setText(name)
            tvStoreMenuPrice.setText(price.toString()+"원")
        }
    }
}

