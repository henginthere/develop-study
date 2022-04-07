package com.ssafy.kotlin

import kotlin.random.Random

enum class SsafyHandsome {
    SSAFY, LOVE, PEACE
}

enum class Human(val age: Int) {
    KIM(25), CHOI(21)
}

enum class Game(val msg: String) {
    ROCK("바위"),
    SCISSORS("가위"),
    PAPER("보")
}

fun main() {
    val ssafyEnum: SsafyHandsome = SsafyHandsome.SSAFY
    println("${ssafyEnum.name} ... ${ssafyEnum.ordinal}")

    val ssafyEnum2: Array<SsafyHandsome> = SsafyHandsome.values()

    for (i in ssafyEnum2.indices) {
        println(ssafyEnum2[i].name)
    }

    val human: Human = Human.KIM
    println("${human.name}, ${human.age}, ${human.ordinal}")

    val randomValue = Random.nextInt(0, 3)
    val selected = Game.values()[randomValue]
    println("${selected.msg}를 냈습니다.")

    when (selected) {
        Game.ROCK -> println("바위는 보로 이길 수 있습니다.")
        Game.SCISSORS -> println("가위는 바위로 이길 수 있습니다.")
        Game.PAPER -> println("보는 가위로 이길 수 있습니다.")
    }
}

