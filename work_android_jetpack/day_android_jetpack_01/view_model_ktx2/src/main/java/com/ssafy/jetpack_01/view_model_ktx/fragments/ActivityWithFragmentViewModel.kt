package com.ssafy.jetpack_01.view_model_ktx.fragments

import androidx.lifecycle.ViewModel

class ActivityWithFragmentViewModel : ViewModel() {
    // 사용자의 클릭수를 세는 변수
    var count = 0
        private set

    // 사용자가 클릭 했을 때 클릭수를 증가시키는 메소드
    fun increaseCount() {
        count++
    }

    fun decreaseCount() {
        count--
    }
}