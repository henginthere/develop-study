package com.ssafy.ssafygo

import android.Manifest
import android.bluetooth.*
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.Intent
import android.content.pm.PackageManager
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.os.Bundle
import android.os.RemoteException
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.ssafy.ssafygo.dto.StoreDTO
import com.ssafy.ssafygo.service.StoreService
import com.ssafy.ssafygo.storeMenu.StoreMenuActivity
import com.ssafy.ssafygo.storeMenu.StoreMenuDetailActivity
import org.altbeacon.beacon.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() , BeaconConsumer {

    private lateinit var beaconManager: BeaconManager
    private val BEACON_UUID = "fda50693-a4e2-4fb1-afcf-c6eb07647825"
    private val BEACON_MAJOR = "10004"
    private val BEACON_MINOR = "54480"
     //Beacon의 Region 설정

//    private val region1 = Region("altbeacon"
//        , Identifier.parse(BEACON_UUID)
//        , Identifier.parse(BEACON_MAJOR)
//        , Identifier.parse(BEACON_MINOR)
//    )
    private val PERMISSIONS_CODE = 100

    // 모든 퍼미션 관련 배열
    private val requiredPermissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
    )
    private val STORE_DISTANCE = 1


    private val region = Region("altbeacon",null,null,null)

    private var bluetoothAdapter: BluetoothAdapter? = null
    private var needBLERequest = true

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
                val intent = Intent(this, StoreMenuActivity::class.java)
                intent.putExtra("StoreId", STORE_ID)
                startActivity(intent)
            }
        }

        startScan()

    }

    // 블루투스 켰는지 확인
    private fun isEnableBLEService(): Boolean{
        if(!bluetoothAdapter!!.isEnabled){
            return false
        }
        return true
    }

    // Beacon Scan 시작
    private fun startScan() {
        // 블루투스 Enable 확인
        if(!isEnableBLEService()){
            requestEnableBLE()
            Log.d(TAG, "startScan: 블루투스가 켜지지 않았습니다.")
            return
        }

        // 위치 정보 권한 허용 및 GPS Enable 여부 확인
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                this,
                requiredPermissions,
                PERMISSIONS_CODE
            )
        }
        Log.d(TAG, "startScan: beacon Scan start")

        // Beacon Service bind
        beaconManager.bind(this)
    }

    // 블루투스 ON/OFF 여부 확인 및 키도록 하는 함수
    private fun requestEnableBLE(){
        val callBLEEnableIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        requestBLEActivity.launch(callBLEEnableIntent)
        Log.d(TAG, "requestEnableBLE: ")
    }

    private val requestBLEActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        // 사용자의 블루투스 사용이 가능한지 확인
        if (isEnableBLEService()) {
            needBLERequest = false
            startScan()
        }
    }

    // 위치 정보 권한 요청 결과 콜백 함수
    // ActivityCompat.requestPermissions 실행 이후 실행
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSIONS_CODE -> {
                if(grantResults.isNotEmpty()) {
                    for((i, permission) in permissions.withIndex()) {
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            //권한 획득 실패
                            Log.i(TAG, "$permission 권한 획득에 실패하였습니다.")
                            finish()
                        }
                    }
                }
            }
        }
    }
    override fun onBeaconServiceConnect() {

        beaconManager.addMonitorNotifier(object : MonitorNotifier {

            override fun didEnterRegion(region: Region?) {
                try {
                    Log.d(TAG, "비콘을 발견하였습니다.------------${region.toString()}")
                    beaconManager.startRangingBeaconsInRegion(region!!)
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
            }

            override fun didExitRegion(region: Region?) {
                try {
                    Log.d(TAG, "비콘을 찾을 수 없습니다.")
                    beaconManager.stopRangingBeaconsInRegion(region!!)
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
            }

            override fun didDetermineStateForRegion(i: Int, region: Region?) {}
        })

        beaconManager.addRangeNotifier { beacons, region ->
            for (beacon in beacons) {
                // Major, Minor로 Beacon 구별, 1미터 이내에 들어오면 메세지 출력

                if(isYourBeacon(beacon)){
                    // 한번만 띄우기 위한 조건
                    Log.d(TAG, "distance: " + beacon.distance + " Major : " + beacon.id2 + ", Minor" + beacon.id3)
                    getStoreInfo()
                }
            }

            if(beacons.isEmpty()){

            }
        }

        try {

            beaconManager.startMonitoringBeaconsInRegion(region)


        } catch (e: RemoteException){
            e.printStackTrace()
        }
    }

    // 찾고자 하는 Beacon이 맞는지, 정해둔 거리 내부인지 확인
    private fun isYourBeacon(beacon: Beacon): Boolean {
//        return (beacon.id2.toString() == BEACON_MAJOR &&
//                beacon.id3.toString() == BEACON_MINOR &&
//                beacon.distance <= STORE_DISTANCE
//                )
        return (beacon.distance <= STORE_DISTANCE)
    }

    // 꼭 Destroy를 시켜서 beacon scan을 중지 시켜야 한다.
    // beacon scan을 중지 하지 않으면 일정 시간 이후 다시 scan이 가능하다.
    override fun onDestroy() {
        beaconManager.stopMonitoringBeaconsInRegion(region)
        beaconManager.stopRangingBeaconsInRegion(region)
        beaconManager.unbind(this)
        super.onDestroy()
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
