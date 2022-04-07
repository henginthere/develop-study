package com.ssafy.kotlin

fun stringExtensionTest(){
    // 문자열 확장 함수
    fun String.lastChar(): Char = this.get(this.length - 1)

    println("Hello World".lastChar()) // d
}


fun staticExtension(){
    open class MyView {
        open fun click() = println("View clicked")
    }
    class MyButton: MyView() {
        override fun click() = println("Button clicked")
    }

    // 기능 확장
    fun MyView.showOff() = println("I'm a view!")
    fun MyButton.showOff() = println("I'm a button!")
    // 부모 타입으로 자식 객체 생성
    val view: MyView = MyButton()
    view.showOff()
    view.click()
}


fun main() {

    stringExtensionTest() //d
    staticExtension();

}
