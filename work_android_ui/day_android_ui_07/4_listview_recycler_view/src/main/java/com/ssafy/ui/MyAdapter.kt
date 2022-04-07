package com.ssafy.ui

import android.content.Context
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "MyAdapter_싸피"
class MyAdapter
    (context: Context, val resource: Int, val objects: Array<String>)
    : RecyclerView.Adapter<ViewHolder>() {

    // viewType 형태의 아이템 뷰를 위한 뷰홀더 객체 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(resource, parent, false)

        Log.d(TAG, "onCreateViewHolder: ViewHolder 객체 생성 !!")
        return ViewHolder(itemView)
    }

    // position에 해당하는 데이터를 뷰홀더의 아이템 뷰에 표시
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 한 행에 데이터를 넣어준다.
        holder.tvName.text = objects[position]
        Log.d(TAG, "onBindViewHolder: $position 행에 ${objects[position]} 데이터 삽입")

        // OnItemClickListener 연결
        holder.bindOnItemClickListener(onItemClickListener)
    }

    // 전체 아이템 개수 리턴
    override fun getItemCount(): Int {
        return objects.size
    }

    // 클릭 처리 기능이 내장되어 있지 않아 OnItemClickListener 인터페이스 구현
    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
    lateinit var onItemClickListener: OnItemClickListener
}

// ViewHolder 클래스 생성
class ViewHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {
    var tvName = itemView.findViewById(R.id.tv_name) as TextView

    fun bindOnItemClickListener(onItemClickListener: MyAdapter.OnItemClickListener) {
        itemView.setOnClickListener {
            onItemClickListener.onItemClick(it, adapterPosition)
        }
    }

    // Context 메뉴 생성
    override fun onCreateContextMenu(menu: ContextMenu?,
                                     v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        // 테스트용 메뉴 등록
        menu?.add(0, 0, adapterPosition, "컨텍스트 메뉴 1")
    }
    
    // Context 메뉴 리스너 등록
    init {
        itemView.setOnCreateContextMenuListener(this)
    }
}