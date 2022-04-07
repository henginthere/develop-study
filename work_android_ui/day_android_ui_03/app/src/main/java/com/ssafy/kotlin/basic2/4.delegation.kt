package com.ssafy.kotlin.basic2

interface Animal {
    fun eat() {
        println("Animal.eat()")
    }
}

class Cat: Animal {

}

val cat = Cat()

class Robot: Animal by cat
// Animal의 정의된 Cat의 모든 멤버를 Robot에 위임함
// cat은 Animal 자료형의 private 멤버로 Robot 클래스 내에 저장
// Animal에 대한 명시적인 참조를 사용하지 않고도 eat()을 호출

fun main() {
    var robot = Robot()
    robot.eat()
    println(robot::class.java)
}