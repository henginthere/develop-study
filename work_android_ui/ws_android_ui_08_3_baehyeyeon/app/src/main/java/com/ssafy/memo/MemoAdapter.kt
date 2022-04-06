package com.ssafy.memo

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemoAdapter(
    context: Context, val resource: Int, val objects: MutableList<MemoDto>
) : RecyclerView.Adapter<MemoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(resource, parent, false)

        return MemoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        // 한 행에 데이터를 넣어준다.

        holder.tvMemo.text = objects[position].memoTitle
        holder.tvContent.text = objects[position].memoContent
        holder.tvDate.text = objects[position].memoDate
        //Log.d(TAG, "onBindViewHolder: $position 행에 ${objects[position]} 데이터 삽입")

        // OnItemClickListener 연결
        holder.bindOnItemClickListener(onItemClickListener)
        when(position%3){
            0->holder.tvMemo.setBackgroundColor(Color.parseColor("#cbe6c8"))
            1->holder.tvMemo.setBackgroundColor(Color.parseColor("#e6c8e2"))
            2->holder.tvMemo.setBackgroundColor(Color.parseColor("#c8dee6"))

        }
    }

    override fun getItemCount(): Int {
        return objects.size
    }

    // 클릭 처리 기능이 내장되어 있지 않아 OnItemClickListener 인터페이스 구현
    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
    lateinit var onItemClickListener: OnItemClickListener
}

class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnCreateContextMenuListener {
    var tvMemo = itemView.findViewById(R.id.todo) as TextView
    var tvContent = itemView.findViewById(R.id.detail) as TextView
    var tvDate = itemView.findViewById(R.id.time) as TextView

    fun bindOnItemClickListener(onItemClickListener: MemoAdapter.OnItemClickListener) {
        itemView.setOnClickListener {
            onItemClickListener.onItemClick(it, adapterPosition)
        }
    }

    // Context 메뉴 생성
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) { //v : 사용자가 길게 누른 것
        menu?.add(0, 0, adapterPosition, "삭제")
    }

    // Context 메뉴 리스너 등록
    init {
        itemView.setOnCreateContextMenuListener(this)
    }

}
