package com.ssafy.gallery

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter

private const val TAG = "PhotoViewModel"

// 레이아웃이 홀더 함수 내부에서 PhotoViewModel의 Photo 객체를 변경했음을 알 수 있는 방법이 없기 때문에
// 바인딩 데이터가 변경되었을 때 뷰모델이 레이아웃 파일과 소통하게 만든다.
class PhotoViewModel: BaseObservable() {

    var photo: Photo? = null
        set(photo) {
            field = photo
            notifyChange()
        }
    @get:Bindable
    val src: String?
        get() = photo?.src
}

// 일반적인 방법으로 ImageSrc를 넘기면 사진이 나오지 않는다.
// 다음과 같이 BindingAdapter를 생성하여 넘겨주어야 한다.
// layout 파일에서는
// app:imageUrl="@{viewModel.src}"
// 과 같이 사용한다.
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    val packageName = "com.ssafy.gallery"
    val resId = view.resources.getIdentifier(url, "drawable", packageName)
    view.setImageResource(resId)
}