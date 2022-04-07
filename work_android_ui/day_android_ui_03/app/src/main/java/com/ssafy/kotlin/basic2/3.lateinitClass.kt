package com.ssafy.kotlin.basic2

class Person {
    lateinit var name: String  // 늦은 초기화를 위한 선언
    fun test() {
        if(! ::name.isInitialized) {  // 프로퍼티의 초기화 여부 판단
            println("not initialized")
        } else {
            println("initialized")
        }
    }
}

fun main() {
    val gildong = Person()
    gildong.test()
    gildong.name = "Gildong" // 이 시점에서 초기화됨(지연 초기화)
    gildong.test()
    println("name = ${gildong.name}")

    val test = LazyTest()
    test.flow()
}

class LazyTest {
    init {
        println("init block")
    }
    val subject by lazy {
        println("lazy initialized")
        "Kotlin Programming"  // lazy 반환값
    }
    fun flow() {
        println("not initialized") //
        println("subject one: $subject")  // 최초 초기화 시점!
        println("subject two: $subject")  // 이미 초기화된 값 사용
    }
}

