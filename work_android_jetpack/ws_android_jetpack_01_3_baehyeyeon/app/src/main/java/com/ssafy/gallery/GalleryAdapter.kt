package com.ssafy.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.gallery.databinding.ListItemGalleryBinding

class GalleryAdapter(private val photoList: MutableList<Photo>):
    RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

        //list_item_gallery와 연결되는 ViewHolder
        inner class ViewHolder(private val binding: ListItemGalleryBinding): RecyclerView.ViewHolder(binding.root){

            init{
                binding.viewModel = PhotoViewModel()
            }
            fun bind(item: Photo){
                binding.apply {
                    // 각 아이템의 Photo 객체를 PhotoViewModel에 연결시킨다.
                    viewModel?.photo = item

                    // Binding 실행
                    // 변수 또는 관찰 가능한 객체가 변경될 때 결합은 다음 프레임 이전에 변경되도록 예약됩니다.
                    // 하지만 결합이 즉시 실행되어야 하는 때도 있습니다.
                    // 이럴 때 강제로 실행하려면 executePendingBindings() 메서드를 사용하세요.
                    executePendingBindings()

                    // 클릭 리스너 연결
                    itemView.setOnClickListener {
                        itemClickListner.onClick(it, item, adapterPosition)
                    }
                }
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //list_item_gallery와 연결
        var listItemBinding: ListItemGalleryBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item_gallery, parent, false)
        return ViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photoList[position]
        holder.bind(photo)
    }

    override fun getItemCount() = photoList.size
    interface ItemClickListener {
        fun onClick(view: View, dto:Photo, position: Int)
    }

    private lateinit var itemClickListner: ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }
}