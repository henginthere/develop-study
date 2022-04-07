package com.ssafy.kotlin

//let also
fun main() {
    var arr = arrayOf(1, 2, 3)
    arr.let { println("${it[1] + it[2]}") } //let 람다식 내부에서 arr[1] + arr[2] 를 출력

    println(arr.let { it[1] + it[2] }.plus(arr[0]))//let 람다식에서 계산한 arr[1] + arr[2] 를 반환하고 arr[0]을 더해서 출력


    var student = Student("Park",11)

    var student2 = student.also {
        it.age = 15
        it.name = "kim"
    }

    println(student)
    println(student2)
}

data class Student(var name : String, var age : Int)
