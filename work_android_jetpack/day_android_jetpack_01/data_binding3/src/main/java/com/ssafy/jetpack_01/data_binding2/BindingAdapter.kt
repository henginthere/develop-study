package com.ssafy.jetpack_01.data_binding2

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageDrawable")
fun bindImageFromRes(view: ImageView, drawable: Drawable?) {
    view.setImageDrawable(drawable)
}
