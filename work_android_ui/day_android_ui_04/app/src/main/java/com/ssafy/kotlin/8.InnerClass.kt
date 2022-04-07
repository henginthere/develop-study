package com.ssafy.kotlin

import javax.xml.transform.sax.SAXSource

// nested class 중첩 클래스
class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
        //fun foo() = bar
        //fun foo() = this@Outer.bar
    }
}


// inner class 내부 클래스
class OuterInner {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
        //fun foo() = this@OuterInner.bar
    }
}


fun main() {
    val demo = Outer.Nested().foo() // == 2
    val demo2 = OuterInner().Inner().foo() // == 1
    println(demo)
    println(demo2)
}

