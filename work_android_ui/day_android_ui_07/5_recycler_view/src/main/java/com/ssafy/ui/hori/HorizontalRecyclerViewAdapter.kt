package com.ssafy.ui.hori

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.ui.R

// 개별 데이터(Transportation)를 item_horizontal_recyclerview.xml과 연결하는 holder 구성
class TransportationHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindInfo(data: Transportation) {
        itemView.findViewById<TextView>(R.id.title_tv).text = data.title
        itemView.findViewById<ImageView>(R.id.logo_iv).setImageResource(data.logo)
    }
}

class HorizontalRecyclerViewAdapter(private val context: Context,
                                    private val dataList: MutableList<Transportation>) : RecyclerView.Adapter<TransportationHolder>() {

    // 아이템과 아이템 레이아웃을 바인딩 하는 UserInfoHolder 생성 및 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransportationHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_horizontal_recyclerview, parent, false)
        return TransportationHolder(itemView)
    }

    override fun onBindViewHolder(holder: TransportationHolder, position: Int) {
        holder.apply {
            bindInfo(dataList[position])
            itemView.setOnClickListener {
                Toast.makeText(context, "클릭! 위치 $position", Toast.LENGTH_SHORT).show()
            }
            itemView.setOnLongClickListener {
                Toast.makeText(context, "롱~~ 클릭! 위치 $position", Toast.LENGTH_SHORT).show()
                false
            }
        }
    }
    override fun getItemCount(): Int = dataList.size
}
