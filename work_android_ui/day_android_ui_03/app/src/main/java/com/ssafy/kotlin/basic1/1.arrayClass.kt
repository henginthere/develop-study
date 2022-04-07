package com.ssafy.kotlin.basic1

fun main(args: Array<String>) {

//    println(args[0])
//    println(args[1])
//    println(args[2])

    val num: Array<Int> = arrayOf(1, 2, 3, 4) //value : 값(수정불가)
    val num2 = arrayOf(5, 'a', "hi!", 8)
    println(num[0])   // 1
    println(num2[1])  // a
    println(num2[2]) // hi!

// num : Array<Int> 에다가 arrayOf(1, 'a', "hi", 4) 라고 Int형이 아닌 값들을 넣으면 에러가 남
// 반면 그냥 arrayOf() 만 한 배열에는 뭘 넣어도 에러가 안납니다.
}


