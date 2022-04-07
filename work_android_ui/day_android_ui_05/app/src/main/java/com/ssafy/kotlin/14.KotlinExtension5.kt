package com.ssafy.kotlin

class NewList2 {
    private val list = ArrayList<Int>()

    fun add(num: Int) {
        list.add(num)
    }

    fun getHigherThan(num: Int): List<Int> {
        val result = arrayListOf<Int>()
        list.forEach { it->
            if (it > num) {
                result.add(it)
            }
        }
        return result
    }
}

fun main() {
    val numbers2 = NewList2()
    numbers2.add(1)
    numbers2.add(2)
    numbers2.add(3)
    numbers2.add(4)
    numbers2.add(5)
    numbers2.add(6)
    val filtered = numbers2.getHigherThan(3).toString()
    println(filtered)
}