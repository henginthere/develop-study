package com.ssafy.ssafygo.receipt

import android.app.AlertDialog
import android.app.PendingIntent
import android.content.DialogInterface
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NdefMessage
import android.nfc.NdefRecord
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.nfc.tech.Ndef
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.ssafy.ssafygo.ApplicationClass
import com.ssafy.ssafygo.R
import com.ssafy.ssafygo.databinding.ActivityReceiptListBinding
import com.ssafy.ssafygo.dto.ReceiptDTO
import com.ssafy.ssafygo.dto.StoreMenuDTO
import com.ssafy.ssafygo.service.ReceiptService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

private const val TAG="ReceiptListActivity_싸피"

class ReceiptListActivity : AppCompatActivity() {

    private lateinit var nfcAdapter: NfcAdapter
    private lateinit var pendingIntent: PendingIntent
    private lateinit var filters: Array<IntentFilter>

    private var receiptList: ArrayList<ReceiptDTO> = arrayListOf()
    private lateinit var adapter: ArrayAdapter<ReceiptDTO>
    private lateinit var receipt: ReceiptDTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt_list)
        val listview: ListView = findViewById(R.id.listview_receipt)

        // Adapter와 ListView 연결
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, receiptList)
        listview.adapter = adapter

//        val orderMenu = intent.getSerializableExtra("orderMenu") as ReceiptDTO
//        Log.d(TAG, "onCreate: ${orderMenu.time}")
        setReceiptList()

        val btnWriteReceipt:Button = findViewById(R.id.btn_write_receipt)
        btnWriteReceipt.setOnClickListener {
            ApplicationClass.mWriteMode = true
            receipt = receiptList[receiptList.size-1]
            initNfcAdapter()
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

        val service = ApplicationClass.retrofit.create(ReceiptService::class.java)
        service.selectAllReceipt().enqueue(object : Callback<MutableList<ReceiptDTO>> {
            override fun onResponse(call: Call<MutableList<ReceiptDTO>>, response: Response<MutableList<ReceiptDTO>>) {
                if (response.code() == 200) {
                    val res = response.body()
                    Log.d(TAG, "onResponse: res값 ${res?.get(0)?.menuName}")
                    receiptList.clear()
                    if(res != null) {
                        receiptList.addAll(res)
                        Log.d(TAG, "onResponse: $receiptList")
                    }else{
                        Toast.makeText(this@ReceiptListActivity,
                            "Receipt 정보를 가져올 수 없습니다.",
                            Toast.LENGTH_SHORT)
                            .show()
                    }
                    adapter.notifyDataSetChanged()
                    Log.d(TAG, "onResponse: $res")
                }else{
                    Log.d(TAG, "onResponse: Error Code ${response.code()}")
                }



            }

            override fun onFailure(call: Call<MutableList<ReceiptDTO>>, t: Throwable) {
                Log.d(TAG, t.message ?: "Receipt 정보 불러오는 중 통신오류")
            }

        })
    }
    fun initNfcAdapter(){
        nfcAdapter = NfcAdapter.getDefaultAdapter(this)
        if(nfcAdapter == null){
            finish()
        }
        // 태그 정보가 포함된 인텐트를 처리할 액티비티
        val intent = Intent(this, ReceiptListActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val tagFilter = IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED)
        filters = arrayOf(tagFilter)
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, filters, null)

    }

    override fun onResume() {
        super.onResume()
        if(ApplicationClass.mWriteMode) {
            nfcAdapter.enableForegroundDispatch(this, pendingIntent, filters, null)
        }
    }

    override fun onPause() {
        super.onPause()
        if(ApplicationClass.mWriteMode) {
            nfcAdapter.disableForegroundDispatch(this)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if(ApplicationClass.mWriteMode) {
            Log.d(TAG, "onNewIntent: writemode")
            val detectTag = intent!!.getParcelableExtra<Tag>(NfcAdapter.EXTRA_TAG)
            //writeTag 함수 호출
            val ndefMessage = makeNdefMsg("T", receipt.toString())
            if (detectTag != null) {
                writeTag(ndefMessage, detectTag)
            }
        }
    }



    private fun makeNdefMsg(type: String, data: String): NdefMessage {

        var ndefMessage: NdefMessage? = null
        var ndefRecode: NdefRecord? = null
        var ndefRecord1: NdefRecord? =null

        if(type.equals("T")){
            //textRecord
            ndefRecode = NdefRecord.createTextRecord("ko", data)
            //AAR
//            ndefRecord1 = NdefRecord.createApplicationRecord("com.ssafy.ssafygo")
        }
        else if(type.equals("U")){
            ndefRecode = NdefRecord.createUri(data)
//            ndefRecord1 = NdefRecord.createApplicationRecord("com.ssafy.ssafygo")
        }
        else{
            //unknown

        }
        return NdefMessage(arrayOf(ndefRecode))
    }

    //NFC tag 에 데이터를 write
    private fun writeTag(msg: NdefMessage, tag: Tag){
        //Ndef 객체를 얻는다: Ndef.get(tag)
        val ndef = Ndef.get(tag)
        val msgSize = msg.toByteArray().size

        if(ndef != null) {
            //Ndef객체를 이용해서 connect
            ndef.connect()
            //tag가 write모드를 지원하는지 여부
            if(!ndef.isWritable){
                Toast.makeText(this, "Write를 지원하지 않습니다.", Toast.LENGTH_SHORT).show()
                return
            }
            if(ndef.maxSize < msgSize){
                Toast.makeText(this, "Write할 데이터가 태그 크기보다 큽니다.", Toast.LENGTH_SHORT).show()
                return
            }
            Toast.makeText(this, "태그에 데이터를 write 합니다", Toast.LENGTH_SHORT).show()
            //Ndef객체의 writeNdefMessage(msg) 태그에 write
            ndef.writeNdefMessage(msg)
        }
        ApplicationClass.mWriteMode = false
        finish()
    }
}