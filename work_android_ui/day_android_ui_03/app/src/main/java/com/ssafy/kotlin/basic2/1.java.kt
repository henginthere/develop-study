package com.ssafy.kotlin.basic2

class Computer { // 클래스의 정의
    // 프로퍼티들(속성)
    var name: String = "myComputer"
    var part: Int = 2
    var color: String = "blue"

    // 메서드들(함수)
    fun play() = println("computer part: $part")

    fun playGame(vol: Int) = println("game vol: $vol")
}

fun main() {
    val computer = Computer() // 클래스의 생성자를 통한 객체의 생성
    computer.color = "blue" // 객체의 프로퍼티에 값 할당
    println("computer.color: ${computer.color}") // 객체의 멤버 프로퍼티 읽기
    computer.play() // 객체의 멤버 메서드의 사용
    computer.playGame(3)

    val human = Human("김싸피",30)
    human.play()
}

//  상속 가능한 클래스를 위해 open 사용
open class Human (var name: String, var age: Int) { // 주생성자
    fun play() = println("name: $name")
    fun sing(vol: Int) = println("Sing age: $age")
}


//  주 생성자를 사용하는 상속
class Woman (name: String, age: Int) : Human(name, age) {
    fun singHitone() = println("Happy Song!") // 새로 추가된 메서드
}

//  부 생성자를 사용하는 상속
class Man : Human {
    val race: String
    constructor(name: String, age: Int, race: String) : super(name, age) {
        this.race = race// 새로 추가된 프로퍼티
    }
class Human5 (var name: String="NONAME", var age:Int=29){ //주생성자
    fun play() = println("name: $name")
}


}

