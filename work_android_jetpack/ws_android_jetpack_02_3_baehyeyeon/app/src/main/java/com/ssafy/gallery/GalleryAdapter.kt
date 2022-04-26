package com.ssafy.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.gallery.databinding.ListItemGalleryBinding

class GalleryAdapter(val context: Context, private val photoList: MutableList<Photo>):
    RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

        inner class ViewHolder(private val binding: ListItemGalleryBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(item: Photo){
                binding.apply {
                    // layout의 variable에 Photo 객체 할당
                    photo = item
                }
            }

            fun bindOnItemClickListener(onItemClickListener: GalleryAdapter.OnItemClickListener) {
                itemView.setOnClickListener {
                    onItemClickListener.onItemClick(it, adapterPosition)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var listItemBinding: ListItemGalleryBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item_gallery, parent, false)
        return ViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photoList[position]
        holder.apply {
            bind(photo)
            itemView.tag = photo
            bindOnItemClickListener(onItemClickListener)
        }
    }

    override fun getItemCount() = photoList.size

    // 클릭 처리 기능이 내장되어 있지 않아 OnItemClickListener 인터페이스 구현
    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    lateinit var onItemClickListener: OnItemClickListener
}