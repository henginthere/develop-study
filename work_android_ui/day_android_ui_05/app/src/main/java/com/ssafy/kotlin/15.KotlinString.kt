package com.ssafy.kotlin

fun greet(name: String) {
    // 값 name을 직접 문자열 내에 대입합니다.
    println("Hello, $name")
}

fun add(a: Int, b: Int) {
    // 값 a, b와 a + b의 계산값을 대입합니다.
    // 표현식을 사용하는 경우 '$'기호와 중괄호를 함께 사용합니다.
    println("$a + $b is ${a + b}")
}

fun foo() {
    val heroes = """
        |D.Va
        |Lucio
        |Mercy
        |Soldier: 76
        """.trimMargin()

    // Other logics...
}

class HeroName(val firstName: String, val lastName: String)

fun joinStringTest1(){
    val items = listOf("D.Va", "Lucio", "Mercy", "Soldier: 76")
    println(items.joinToString()) // "D.Va, Lucio, Mercy, Soldier: 76" 출력
    println(items.joinToString("-")) // "D.Va-Lucio-Mercy-Soldier: 76" 출력

    val items2 = listOf(HeroName("Hana", "Song"), HeroName("Jack", "Morrison"))
    println(items2.joinToString { "${it.firstName} ${it.lastName}" }) // "Hana Song, Jack Morrison" 출력
}

fun main() {
    // "Hello, Hana Song" 출력
    greet("Hana Song")

    // "1 + 3 = 4" 출력
    add(1, 3)

    foo()

    joinStringTest1()

}

