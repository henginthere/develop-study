package com.ssafy.kotlin

data class Student2(var name : String, var age : Int)

fun main() {
    var student = Student2("Park",11)

    var student2 = student.apply {
        age = 15 //this 생략
        name = "kim" //this 생략
    }
    var a = 10
    var b = 15

    var result = run {
        var c = a + b
        println(c)
        c
    }//더하기 작업 수행 후 결과 c 반환

    result = result.run {
        plus(5)
    }
    println(result)

    println(student)
    println(student2)


    var people = People("Park", 15)

    var newAge = with(people) {
        age = 20
        age
    }

    println(newAge)
}

data class People(var name : String, var age : Int)