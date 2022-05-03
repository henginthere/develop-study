package com.ssafy.ssafygo.storeMenu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.ssafy.ssafygo.ApplicationClass
import com.ssafy.ssafygo.R
import com.ssafy.ssafygo.dto.StoreMenuDTO
import com.ssafy.ssafygo.receipt.ReceiptListActivity
import com.ssafy.ssafygo.service.StoreMenuService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "StoreMenuActivity_싸피"
class StoreMenuActivity : AppCompatActivity() {

    private var storeId = 1

    private var storeMenuList: ArrayList<StoreMenuDTO> = arrayListOf()
    private lateinit var adapter: ArrayAdapter<StoreMenuDTO>
    private lateinit var btnReceipt:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_menu)

        storeId = intent.getIntExtra("StoreId", -1)

        val listview: ListView = findViewById(R.id.listview_store_menu)

        // Adapter와 ListView 연결
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, storeMenuList)
        listview.adapter = adapter

        val requestActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                val intent: Intent? = activityResult.data

                //Log.d(TAG, "onCreate: $storeReview")

                }
            }


        // 메뉴 상세정보 보기
        listview.setOnItemClickListener { parent, view, position, id ->
            val storeMenu = storeMenuList[position]
            requestActivity.launch(Intent(this, StoreMenuDetailActivity::class.java).apply {
                putExtra("StoreMenu", storeMenu)
            })
        }



        btnReceipt = findViewById(R.id.btn_receipt)

        btnReceipt.setOnClickListener {
//            val intent = Intent(this, ReceiptListActivity::class.java)
//            startActivity(intent)
            Log.d(TAG, "onCreate: 왜 안되지?")
        }
        getStoreMenuInfo(storeId)
    }

    // 메뉴 정보 모두 가져오기
    private fun getStoreMenuInfo(storeId: Int) {
        val storeService = ApplicationClass.retrofit.create(StoreMenuService::class.java)
        // enqueue를 통해 비동기적으로 API 호출 작업 수행
        storeService.findAllStoreMenuByStoreId(storeId).enqueue(object : Callback<List<StoreMenuDTO>> {
            override fun onResponse(call: Call<List<StoreMenuDTO>>, response: Response<List<StoreMenuDTO>>) {
                val res = response.body()
                if (response.code() == 200) {
                    storeMenuList.clear()
                    if (res != null) {
                        storeMenuList.addAll(res)
                    }
                    else {
                        Toast.makeText(this@StoreMenuActivity,
                            "리뷰정보를 가져올 수 없습니다.",
                            Toast.LENGTH_SHORT)
                            .show()
                    }
                    adapter.notifyDataSetChanged()
                    Log.d(TAG, "onResponse: $res")
                }
                else {
                    Log.d(TAG, "onResponse: Error Code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<StoreMenuDTO>>, t: Throwable) {
                Log.d(TAG, t.message ?: "리뷰 정보 불러오는 중 통신오류")
            }
        })
    }

}