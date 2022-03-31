package com.ssafy.memo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "MainActivity_싸피"

class MainActivity : AppCompatActivity() {

    //MemoItemMgr
    private lateinit var memoItemMgr: MemoItemMgr

    //listView에 들어갈 메모(String)
    private lateinit var memoList: ArrayList<String>

    private lateinit var listView: ListView
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        //addButton = findViewById(R.id.btnAddMemo)

        memoItemMgr = MemoItemMgr()
        memoItemMgr.add(MemoItem("메모앱만들기1", "메모 앱 서로 연결하기", "2021/05/19 03:19"))
        memoItemMgr.add(MemoItem("메모앱만들기2", "메모 앱 UI 만들기", "2021/05/20 05:22"))
        memoItemMgr.add(MemoItem("메모앱만들기3", "메모 앱 설계하기", "2021/05/21 10:30"))

        setMemoList()
        setListView()

        //리스트 항목 클릭 시 사용할 intent 객체 생성
        val intent = Intent(this, MemoEditActivity::class.java)



        listView.setOnItemClickListener { parent, view, position, id ->
            intent.putExtra("todo", memoItemMgr.memos[position].title)
            intent.putExtra("detail", memoItemMgr.memos[position].content)
            intent.putExtra("time", memoItemMgr.memos[position].date)
            intent.putExtra("num",position)

            memoEditActivityLauncher.launch(intent)
        }

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

        for (i: Int in 0 until memoItemMgr.size()) {
            val title = memoItemMgr.memos[i].title
            val date = memoItemMgr.memos[i].date
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
        var info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        when (item.itemId) {
            R.id.context_menu_delete -> {
                memoItemMgr.remove(info.position)
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
            val tmpMemo = MemoItem(returnTodo, returnDetail, returnTime)

            when(state){
                0->memoItemMgr.add(tmpMemo)
                1->memoItemMgr.update(num, tmpMemo)
                2->memoItemMgr.remove(num)
            }
            setMemoList()
            setListView()
        }

    }
}