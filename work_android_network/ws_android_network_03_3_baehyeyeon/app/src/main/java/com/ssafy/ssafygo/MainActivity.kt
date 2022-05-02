package com.ssafy.ssafygo

import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.ssafy.ssafygo.dto.StoreDTO
import com.ssafy.ssafygo.service.StoreService
import com.ssafy.ssafygo.storeMenu.StoreMenuActivity
import com.ssafy.ssafygo.storeMenu.StoreMenuDetailActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {
    private lateinit var sendBtn: Button

    private lateinit var storeLayout: LinearLayout
    private lateinit var storeNameTV: TextView
    private lateinit var storeTelTV: TextView
    private lateinit var storeLatTV: TextView
    private lateinit var storeLngTV: TextView

    private lateinit var waitTV: TextView

    private lateinit var nfcAdapter: NfcAdapter

    private var STORE_ID=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nfcAdapter = NfcAdapter.getDefaultAdapter(this)
        if(nfcAdapter==null){
            finish()
        }
        var recI = intent
        STORE_ID = processIntent(recI)

        sendBtn = findViewById(R.id.btn_main_cnt_start)
        storeLayout = findViewById(R.id.linear_layout_store_info_layout)
        storeNameTV = findViewById(R.id.tv_store_name)
        storeTelTV = findViewById(R.id.tv_store_tel)
        storeLatTV = findViewById(R.id.tv_store_lat)
        storeLngTV = findViewById(R.id.tv_store_lng)

        waitTV = findViewById(R.id.tv_main_res_text)

        // 가맹점 정보 결과 Layout 숨기기
        storeLayout.visibility = View.INVISIBLE
        waitTV.text = "준비 완료"

        sendBtn.setOnClickListener {
            // 가맹점 정보 결과 Layout 숨기기
            storeLayout.visibility = View.INVISIBLE

            // 버튼 클릭 시 버튼 비활성화
            sendBtn.isEnabled = false
            waitTV.text = "불러오는 중입니다..."
            getStoreInfo()
        }

        storeLayout.setOnClickListener {
            // 가맹점 정보를 잘 불러왔다면 클릭 가능하다.
            if (storeLayout.isVisible) {
                // 클릭하면 해당 가맹점의 리뷰확인 가능
                val intent = Intent(this, StoreMenuDetailActivity::class.java)
                intent.putExtra("StoreId", STORE_ID)
                startActivity(intent)
            }
        }
    }

    private fun processIntent(intent: Intent):Int{
        //1. intent에서 NdefMessage 배열 데이터를 가져온다
        val rawMsg = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)

        //2. Data를 변환
        if(rawMsg!=null){
            val msgArr = arrayOfNulls<NdefMessage>(rawMsg.size)

            for(i in rawMsg.indices){
                msgArr[i] = rawMsg[i] as NdefMessage?
            }

            //3. NdefMessage에서 NdefRecode -> payload
            var payload = msgArr[0]!!.records[0].payload


            //tv.setText("태그 데이터: ${String(payload)}")

            //enssafy 되어 있는 값에서 encoding 부분 제거하고 출력
            Log.d(TAG, "processIntent: 태그 데이터: ${String(payload,3,payload.size-3)}")
            return Integer.parseInt(String(payload,3,payload.size-3))
        }
        return 0
    }

    // 가맹점 정보 가져오기
    private fun getStoreInfo() {
        val storeService = ApplicationClass.retrofit.create(StoreService::class.java)

        // enqueue를 통해 비동기적으로 API 호출 작업 수행
        storeService.findByUid(STORE_ID).enqueue(object : Callback<StoreDTO> {
            override fun onResponse(call: Call<StoreDTO>, response: Response<StoreDTO>) {
                val res = response.body()
                if (response.code() == 200) {
                    if (res != null) {
                        setStoreTV(res)
                    }
                    else {
                        Toast.makeText(this@MainActivity, "가맹점 정보를 불러올 수 없습니다.", Toast.LENGTH_SHORT).show()
                    }
                    Log.d(TAG, "onResponse: $res")
                    sendBtn.isEnabled = true
                }
                else {
                    waitTV.text = "불러오기 실패"
                    sendBtn.isEnabled = true
                    Log.d(TAG, "onResponse: Error Code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<StoreDTO>, t: Throwable) {
                waitTV.text = "불러오기 실패"
                sendBtn.isEnabled = true
                Log.d(TAG, t.message ?: "가맹점 정보 불러오는 중 통신오류")
            }
        })
    }

    // 가맹점 정보 표시
    private fun setStoreTV(store: StoreDTO?) {
        if (store != null) {
            waitTV.text = "불러오기 완료!!"
            storeNameTV.text = store.name
            storeTelTV.text = store.tel
            storeLatTV.text = "위도 : ${store.lat}"
            storeLngTV.text = "경도 : ${store.lng}"
            storeLayout.visibility = View.VISIBLE
        }
    }
}
