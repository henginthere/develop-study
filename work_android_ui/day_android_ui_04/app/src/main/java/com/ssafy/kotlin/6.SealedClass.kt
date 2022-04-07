package com.ssafy.kotlin

sealed class Color {
    object Red: Color()
    object Green: Color()
    object Blue: Color()
}

sealed class GameSealed {
    class Rock : GameSealed()
    class Scissors : GameSealed()
    class Paper : GameSealed()
}

fun main() {
    val color: Color = Color.Red
//    val font = when (color) {
//        is Color.Red -> {
//            "Noto Sans"
//        }
//        is Color.Green -> {
//            "Open Sans"
//        }
//        // compile error!
//    }

    val font = when (color) {
        is Color.Red -> "Noto Sans"
        is Color.Green -> "Open Sans"
        is Color.Blue -> "sans-serif"
        // No error!
    }

    println("결정된 font는 : $font")

    val selected: GameSealed = GameSealed.Rock()
    val msg = when(selected) {
        is GameSealed.Rock -> "바위 객체가 생성되었습니다."
        is GameSealed.Scissors -> "가위 객체가 생성되었습니다."
        is GameSealed.Paper -> "보 객체가 생성되었습니다."
    }
    println(msg)
}