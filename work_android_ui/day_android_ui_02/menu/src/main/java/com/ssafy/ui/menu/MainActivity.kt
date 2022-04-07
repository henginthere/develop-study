package com.ssafy.ui.menu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var contextMenuBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contextMenuBtn = findViewById(R.id.context_menu_btn)

        // long click 할 때 context 메뉴를 연결할 view 등록
        registerForContextMenu(contextMenuBtn)


        override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            super.onCreateContextMenu(menu, v, menuInfo)
            menuInflater.inflate(R.menu.contextmenu, menu)
        }

        override fun onContextItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.context_menu_blue -> contextMenuBtn.setTextColor(Color.BLUE)
                R.id.context_menu_red -> contextMenuBtn.setTextColor(Color.RED)
                R.id.context_menu_green -> contextMenuBtn.setTextColor(Color.GREEN)
            }
            return super.onContextItemSelected(item)
        }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            val inflater = menuInflater
            inflater.inflate(R.menu.menutest, menu)
            return super.onCreateOptionsMenu(menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (item.itemId == R.id.item_exit) {
                finish()
            } else {
                Toast.makeText(this, "Hello Menu, ${item.title}", Toast.LENGTH_SHORT).show()
            }
            return super.onOptionsItemSelected(item)
        }
    }
}