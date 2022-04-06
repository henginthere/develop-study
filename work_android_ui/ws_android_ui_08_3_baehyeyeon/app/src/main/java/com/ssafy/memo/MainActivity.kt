package com.ssafy.memo

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log


private const val TAG = "MainActivity_싸피"

class MainActivity : AppCompatActivity() {

    //listView에 들어갈 메모(String)
    private lateinit var memoList: ArrayList<String>

    private lateinit var rListView: RecyclerView
    private lateinit var memoAdapter: MemoAdapter

    //private lateinit var listView: ListView

    //DB 선언부
    private var memoDao = MemoDao()
    private var memo = mutableListOf<MemoDto>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //helper 인스턴스 생성 -> helper() 생성자가 실행되어 memos 파일이 생성된다.
        memoDao.dbOpenHelper(this)
        memoDao.open()

        // 앱 최초 실행 시, 권한 설정
        requirePermission()

        //1. ListView 객체 생성
        rListView = findViewById(R.id.my_list_view2)
        rListView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        setMemoList()

    }

    private fun setMemoList(){
        memo = memoDao.selectAllMemos();
        //2. Adapter 객체 생성(한 행을 위해 반복 생성할 layout과 데이터 전달)
        memoAdapter = MemoAdapter(this, R.layout.custom_item, memo)

        //3. ListView와 Adapter 연결
        rListView.adapter = memoAdapter

        //리스트 항목 클릭 시 사용할 intent 객체 생성
        val intent = Intent(this, MemoEditActivity::class.java)
        memo = memoDao.selectAllMemos();
        //4. 행을 터치했을 때 실행하는 콜백 함수
        val itemClickListener =  object : MemoAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                intent.putExtra("todo", memo[position].memoTitle)
                intent.putExtra("detail", memo[position].memoContent)
                intent.putExtra("time", memo[position].memoDate)
                intent.putExtra("num",position)

                memoEditActivityLauncher.launch(intent)
            }
        }
        memoAdapter.onItemClickListener = itemClickListener
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var memo = memoDao.selectAllMemos()
        memoDao.deleteMemo(memo[item.order])
        setMemoList()
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, MemoEditActivity::class.java)
        if (item.itemId == R.id.option_menu_add) {
            intent.putExtra("todo", "")
            intent.putExtra("detail", "")
            intent.putExtra("time", "")
            intent.putExtra("num", -1)
            memoEditActivityLauncher.launch(intent)
       }
        return super.onOptionsItemSelected(item)
    }

    private val memoEditActivityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val intent = it.data

            val returnTodo = intent!!.getStringExtra("inputTodo").toString()
            val returnDetail = intent!!.getStringExtra("inputDetail").toString()
            val returnTime = intent!!.getStringExtra("inputTime").toString()
            val num = intent.getIntExtra("inputNum",0)
            Log.d(TAG, "$num")
            val state = intent.getIntExtra("state",0)
            //받아온 데이터로 메모 생성
            val tmpMemo = MemoDto(returnTodo, returnDetail, returnTime)

            when(state){
                0->memoDao.insertMemo(tmpMemo)
                1->memoDao.updateMemo(tmpMemo)
            }
            setMemoList()
        }

    }

    // SMS 수신 Permission 함수
    private fun requirePermission() {
        val permissions = arrayOf(Manifest.permission.RECEIVE_SMS)
        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)
        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, permissions, 1)
        }
    }

    //메세지 MEMO 추가
    private fun createSMSMemo(intent: Intent?) {
        if (intent != null) {
            // MemoReceiver에서 온 Data
            val smsSender = intent.getStringExtra("SMSSender").toString()
            val smsContents = intent.getStringExtra("SMSContents").toString()
            val smsDate = intent.getStringExtra("SMSDate").toString()
            val smsState = intent.getBooleanExtra("SMSstate",false)
            val memo = MemoDto(smsSender, smsContents, smsDate)

            // 메시지 수신으로 앱이 실행되는 것과 아닐 때를 구분해 주기 위해
            if (smsState) {
                memoDao.insertMemo(memo)
                //memoItemMgr.add(memo)
            }

            setMemoList()
            //setListView()
        }
    }

    // Activity를 계속 새로 실행하지 않고 재사용할 경우 onCreate가 아닌 onNewIntent를 불러온다.
    // Activity를 새로 시작하지 않고 재사용하기 위해 onNewIntent를 만들어준다.
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        createSMSMemo(intent)
    }
}
