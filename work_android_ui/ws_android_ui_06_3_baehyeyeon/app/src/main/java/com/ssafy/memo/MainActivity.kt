package com.ssafy.memo

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
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


private const val TAG = "MainActivity_싸피"

class MainActivity : AppCompatActivity() {

    //listView에 들어갈 메모(String)
    private lateinit var memoList: ArrayList<String>

    private lateinit var listView: ListView

    //DB 선언부
    private var memoDao = MemoDao()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //helper 인스턴스 생성 -> helper() 생성자가 실행되어 memos 파일이 생성된다.
        memoDao.dbOpenHelper(this)
        memoDao.open()

        // 앱 최초 실행 시, 권한 설정
        requirePermission()

        listView = findViewById(R.id.listView)
        //memoList = arrayListOf()
        //addButton = findViewById(R.id.btnAddMemo)

//        memoItemMgr = MemoItemMgr()
//        memoItemMgr.add(MemoItem("메모앱만들기1", "메모 앱 서로 연결하기", "2021/05/19 03:19"))
//        memoItemMgr.add(MemoItem("메모앱만들기2", "메모 앱 UI 만들기", "2021/05/20 05:22"))
//        memoItemMgr.add(MemoItem("메모앱만들기3", "메모 앱 설계하기", "2021/05/21 10:30"))

        setMemoList()
        setListView()

        //리스트 항목 클릭 시 사용할 intent 객체 생성
        val intent = Intent(this, MemoEditActivity::class.java)
        var memo = memoDao.selectAllMemos();
        listView.setOnItemClickListener { parent, view, position, id ->
            intent.putExtra("todo", memo[position].memoTitle)
            intent.putExtra("detail", memo[position].memoContent)
            intent.putExtra("time", memo[position].memoDate)
            intent.putExtra("num",position)

            memoEditActivityLauncher.launch(intent)
        }
        //registerForContextMenu(listView)
//        addButton.setOnClickListener {
//            intent.putExtra("todo", "")
//            intent.putExtra("detail", "")
//            intent.putExtra("time", "")
//            intent.putExtra("num", -1)
//            memoEditActivityLauncher.launch(intent)
//        }


    }

    //리스트에 뿌려질 메모 setting
    private fun setMemoList() {
        //새 리스트 만들기
        memoList = arrayListOf()
        //var memo: MutableList<MemoDto>
        var memo = memoDao.selectAllMemos()
        for (i: Int in 0 until memo.size) {
            val title = memo[i].memoTitle
            val date = memo[i].memoDate
            println("$title $date ${memo[i].memoContent}")
            memoList.add("$title $date")
        }
    }

    //ListView와 adapter 연결, ListView 내용 갱신
    private fun setListView() {

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, memoList)

        //ListView와 adapter 연결
        listView.adapter = adapter
        adapter.notifyDataSetChanged()
        registerForContextMenu(listView)

    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) { //v : 사용자가 길게 누른 것
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var memo = memoDao.selectAllMemos()
        var info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        when (item.itemId) {
            R.id.context_menu_delete -> {
                //memoItemMgr.remove(info.position)
                memoDao.deleteMemo(memo[info.position])
                setMemoList()
                setListView()
            }
        }
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

            val state = intent.getIntExtra("state",0)
            //받아온 데이터로 메모 생성
            val tmpMemo = MemoDto(returnTodo, returnDetail, returnTime)
            println("ddddddddddddddd $returnTodo $returnDetail $returnTime")
            when(state){
                0->memoDao.insertMemo(tmpMemo)
                1->memoDao.updateMemo(tmpMemo)
                2->memoDao.deleteMemo(tmpMemo)
            }
            setMemoList()
            setListView()
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

    // 메세지 MEMO 추가
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
            setListView()
        }
    }

    // Activity를 계속 새로 실행하지 않고 재사용할 경우 onCreate가 아닌 onNewIntent를 불러온다.
    // Activity를 새로 시작하지 않고 재사용하기 위해 onNewIntent를 만들어준다.
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        createSMSMemo(intent)
    }
}
