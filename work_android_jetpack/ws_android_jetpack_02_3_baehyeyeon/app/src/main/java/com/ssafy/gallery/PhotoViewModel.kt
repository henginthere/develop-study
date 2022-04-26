package com.ssafy.gallery

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

private const val TAG = "PhotoViewModel"

class PhotoViewModel: BaseObservable() {

    // photoList 변경시 레이아웃 파일과 소통
    @get:Bindable
    var photoList: MutableList<Photo> = mutableListOf()
        set(value) {
            field = value

            Log.d(TAG, "photoList 변경 감지")

            notifyPropertyChanged(BR.photoList)
        }
}