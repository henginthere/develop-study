package com.ssafy.ui.basic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.ui.R

// 개별 데이터(UserData)를 item_basic_recyclerview.xml과 연결하는 holder 구성
class UserInfoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindInfo(userData: UserData) {
        itemView.findViewById<TextView>(R.id.title_tv).text = userData.name
        itemView.findViewById<TextView>(R.id.phone_tv).text = userData.phone
        itemView.findViewById<ImageView>(R.id.logo_iv).setImageResource(userData.img)
    }
}

class BasicRecyclerViewAdapter
    (private val context: Context,
     private val userDataList: MutableList<UserData>) : RecyclerView.Adapter<UserInfoHolder>() {

    // 아이템과 아이템 레이아웃을 바인딩 하는 UserInfoHolder 생성 및 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_basic_recyclerview, parent, false)
        return UserInfoHolder(itemView)
    }

    // ViewHolder에 실제 데이터를 binding하는 메서드
    override fun onBindViewHolder(holder: UserInfoHolder, position: Int) {
        holder.apply {
            bindInfo(userDataList[position])
            itemView.setOnClickListener {
                Toast.makeText(context, "클릭! 위치 $position", Toast.LENGTH_SHORT).show()
            }
            itemView.setOnLongClickListener {
                Toast.makeText(context, "롱~~ 클릭! 위치 $position",Toast.LENGTH_SHORT).show()
                false
            }
        }
    }

    override fun getItemCount(): Int = userDataList.size

    fun deleteItem(index: Int) {
        userDataList.removeAt(index)

        // observer에게 아이템이 변경되었음을 알림
        notifyDataSetChanged()
    }
}

