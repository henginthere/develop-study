package com.ssafy.gallery

import android.widget.ImageView
import androidx.databinding.BindingAdapter

// layout의 imageUrl 속성에 값이 입력되면 처리할 어댑터
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    val packageName = "com.ssafy.gallery"
    val resId = view.resources.getIdentifier(url, "drawable", packageName)
    view.setImageResource(resId)
}
