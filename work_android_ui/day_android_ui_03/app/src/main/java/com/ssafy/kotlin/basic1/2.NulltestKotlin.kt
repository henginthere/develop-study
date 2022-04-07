package com.ssafy.kotlin.basic1

fun main() {
    var str2: String = "Hello Kotlin"
    //str2 = null  // null을 허용하지 않음(오류 발생)
    println("str2: $str2")

    var str3: String? = "Hello Kotlin"
    str3 = null  // null을 허용함
    println("str3: $str3")

    var tmp: String? = null
    var size = -1
    if (tmp != null) {
        size = tmp.length
    }
// or
    var temp: String? = null
    val size2 = if (temp != null) temp.length else -1



}
