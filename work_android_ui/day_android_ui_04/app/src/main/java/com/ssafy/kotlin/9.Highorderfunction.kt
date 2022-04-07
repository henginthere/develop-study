package com.ssafy.kotlin

private fun highOrderFunction(sum: (Int, Int) -> Int, a: Int, b: Int): Int = sum(a, b)

fun main() {
    println(highOrderFunction({ x, y -> x + y }, 20, 30))
    println("sumFunction result = ${sumFunction()}")

    val multiply = { x: Int, y: Int -> x * y }
    println("곱셈 결과 = ${multiply(8, 8)}")

    val helloWorld: () -> Unit = { println("Hello World!") }
    val ourSelfSum: (Int) -> Int = { a -> a + a }

    val nestedLambda: () -> () -> Unit = { { println("nested 1") } }

    val print: () -> Unit = { println("print") }
    val print2 = { println("print") }

    helloWorld()
    println(ourSelfSum(10))
    nestedLambda()
    print()
    print2()
}

private fun sum(a: Int, b: Int): Int = a + b
private fun sumFunction(): Int = sum(40, 2)




