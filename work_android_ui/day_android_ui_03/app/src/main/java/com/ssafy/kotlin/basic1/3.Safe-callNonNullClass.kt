package com.ssafy.kotlin.basic1

fun main() {

//    var str1: String? = "Hello Kotlin"
//    str1 = null
//    println("str1: $str1 length: ${str1.length}") // null을 혀용하면 length가 실행될 수 없음
//    ignoreNulls(null)

    val x: String? = null
    println(strLenSafe(x))
    println(strLenSafe("abc"))

    var str: String? = "Hello Kotlin"
    str = null
    println("str : $str length : ${str?.length ?: -1}") //?: : 엘비스 표기법, null이면 -1 출력.
}

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!! //s!!는 null 값이 절대 아니라고 알려주는 것. 그런데 null 값이 들어오니까 nullponinterexception 발생
    println(sNotNull.length)
}

fun strLenSafe(s: String?): Int = if (s != null) s.length else 0

fun getName(str: String?) {
    val name = str ?: "Unknown"
}
