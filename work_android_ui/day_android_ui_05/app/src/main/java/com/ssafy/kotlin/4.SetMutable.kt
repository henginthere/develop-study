package com.ssafy.kotlin

import android.os.Build
import androidx.annotation.RequiresApi

// removeIf의 경우 특정 버전의 API 필요 : N 즉 API 레벨 24 이상 필요
//@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val numbers = mutableSetOf<Int>(33, 22, 11, 1, 22, 3)
    println(numbers)
    numbers.add(100)
    numbers.remove(33)
    println(numbers)
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        numbers.removeIf({ it < 10 }) // 10 이하의 숫자를 삭제
    }
    else{
        for(i in numbers.size-1 downTo 0){ //뒤에서부터 접근해야 자료구조에 문제가 생기지 않음
            if(numbers.elementAt(i)<12)
                numbers.remove(numbers.elementAt(i))
        }
    }
    println(numbers)

}