package com.ssafy.kotlin.basic2

class User1(_id: Int, _name: String, _age: Int) {
    // 프로퍼티
    val id: Int = _id
        get() = field
    var name: String = _name
        get() = field
        set(value) {
            field = value
        }
    var age: Int = _age
        get() = field
        set(value) {
            field = value
        }
}

fun main() {
    val user1 = User1(1, "gildong", 30)
    // user1.id = 2  // 에러! val 프로퍼티는 값 변경 불가
    user1.age = 35  // 세터 동작
    println("user1.age = ${user1.age}")  // 게터 동작
}

