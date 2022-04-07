package com.ssafy.kotlin.basic1

fun main() {

    /* when : switch 대응 */
    val x = 8

    when (x) {
        1 -> println("x == 1")
        2,3 -> println("x == 2 or x == 3")
        in 4..7 -> println("4부터 7사이")
        !in 8..10 -> println("8부터 10사이 아님!!")
        else -> {
            println("x는 1이나 2가 아님")
        }
    }
    // x == 1

    /* if 문 처럼 사용 */
    val num = 10
    val num2 = when (num % 2){
        0 -> "짝"
        else -> "홀"
    }
    println(num2) // 짝

    /* 조건식 반환  */
    doWhen(x)
    doWhen("hello")
    doWhen(100L)
    doWhen('x')

    /* for */
    val num7 = arrayOf(1,2,3,4)
    for(n in num7){
        println(n) // 1; 2; 3; 4;
    }
    for (i in 1..4){
        println(i) // 1; 2; 3; 4;
    }

    for (i in 0..10 step 2){
        println(i) // 0; 2; 4; 6; 8; 10;
    }
    for (i in 10 downTo 0 step 2){
        println(i) // 10; 8; 6; 4; 2; 0
    }

//    for (i in 0..10 step 2){
//        println(i) // 0; 2; 4; 6; 8; 10;
//    }

    // 2차원 배열
    val twoDimens = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6)
    )
    println("***********************************")
    for (i in 0 .. twoDimens.size - 1) {
        for (j in 0 .. twoDimens[i].size - 1) {
            print(twoDimens[i][j])
        }
        println()
    }

    for (i in 0 until twoDimens.size) {
        for (j in 0 until twoDimens[i].size) {
            print(twoDimens[i][j])
        }
        println()
    }
    println("***********************************")

    /* while, dowhile*/
//    var y = 5
//    while (x>0){
//        y--
//        println(y)    // 4; 3; 2; 1; 0;
//    }
//
    var ff = 5
    do {
        ff--
        println(ff) // 4; 3; 2; 1; 0;
    } while (ff>0)
//
    var i = 0
    while(i<10){
        i++
        if (i == 7) break
        if (i%2 == 0) continue
        println(i)

    }
    println("End")
// 1; 3; 5; End;
//
//
    /* Label 사용 */
    out@for (i in 1..5) {
        for (j in 1..5) {
            println("$i + $j = ${i+j}")
            if (i+j >= 5) break@out
        }
    }
    println("hello")
// 1 + 1 = 2; 1 + 2 = 3; 1 + 3 = 4; 1 + 4 = 5; hello
//i+j >= 5 를 만족하면 바로 탈출!

    /* 3항연산자 없음 */
    val a = 33
    val b = 44

    // kotlin
    // 보통의 사용 법
    var max1 = a
    if (a < b) max1 = b

    // With else
    var max2: Int
    if (a > b) {
        max2 = a
    } else {
        max2 = b
    }

// 식으로 --> if else 결과를 리턴받을 수 있음.
    val max3 = if (a > b) a else b
}

fun doWhen(a: Any) {
    var result = when (a) {
        1 -> "정수 1"
        "hello" -> "world"
        is Long -> "Long type"
        !is String -> "String type이 아님"
        else -> "어떤 조건도 만족하지 못 함"
    }

    println(result)
}
