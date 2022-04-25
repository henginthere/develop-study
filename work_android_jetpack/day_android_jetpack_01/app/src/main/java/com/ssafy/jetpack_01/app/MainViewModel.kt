package com.ssafy.jetpack_01.app

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // 사용자의 클릭수를 세는 변수
    var count = 0
        private set  // 외부에서 count 변수를 변경할 수 없도록 설정

    // 사용자가 클릭 했을 때 클릭수를 증가시키는 메서드
    fun increaseCount() {
        count++
    }
}