package com.ssafy.ui.grid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ssafy.ui.R

private const val TAG = "GridRecyclerViewAdapter_싸피"
class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindInfo(food: Food) {
        itemView.findViewById<TextView>(R.id.food_title_tv).text = food.name
        Glide.with(itemView.context)
            .load(food.img)
            .into(itemView.findViewById(R.id.food_iv))
    // Glide.with(itemView.context).load(R.drawable.person1).into(itemView.findViewById(R.id.food_iv))
    // Glide.with(itemView.context).load(food.img).apply(RequestOptions()
    // .placeholder(R.drawable.loading_animation)).into(itemView.findViewById(R.id.food_iv))
    }
}

class GridRecyclerViewAdapter(private val context: Context,
                              private val dataList: MutableList<Food>) : RecyclerView.Adapter<FoodViewHolder>() {

    // 외부에서 OnItemClickListener를 공급받기 위한 작업
    interface OnItemClickListener {
        fun onClick(view: View, position: Int)
    }
    lateinit var onItemClickListener : OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_grid_recyclerview, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.apply {
            bindInfo(dataList[position])
            itemView.setOnClickListener {
                onItemClickListener.onClick(it, position)
            }
        }
    }

    override fun getItemCount(): Int = dataList.size
}