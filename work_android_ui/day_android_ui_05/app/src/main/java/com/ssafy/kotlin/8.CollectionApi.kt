package com.ssafy.kotlin

import android.os.Build
import androidx.annotation.RequiresApi

data class Person(val name: String, val age: Int)

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
//    filterTest()
//    mapTest()
//    mapWithFilterTest()
//    mapToMap()
//    allAnyTest()
//    countTest()
//    findTest()
//    groupByTest()
    groupByTest2()
//    flatMapTest()
//    flattenTest()
}

fun filterTest() {
    /* 리스트에서 짝수만 뽑아내는 예제 */
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 }) //짝수만 필터링


    /* 나이가 30살 이상인 사람만 뽑아내는 예제 */
    val people = listOf(Person("안드로이드", 29), Person("코틀린", 30))
    val filtered = people.filter { it.age >= 30 }
    filtered.forEach {
        println(it);
    }
}

fun mapTest() {
    // 각 원소의 제곱으로 모인 리스트를 만드는 map 예제
    val list = listOf(1, 2, 3, 4)
    println(list.map { it * it }) //제곱 만들기 (1x1, 2x2, 3x3, 4x4)

    // 사람 리스트 -> 이름 리스트 변환
    val people = listOf(Person("안드로이드", 29), Person("코틀린", 30))
    val mapped = people.map { it -> it.name }
    mapped.forEach {
        println(it)
    }
}

fun mapWithFilterTest() {
    // 나이 30 이상인 사람의 이름 목록
    val peoples = listOf(Person("안드로이드", 29), Person("코틀린", 30))
    println(peoples.filter { it.age >= 30 }.map { it.name })

    // 나이가 가장 많은 사람의 이름을 알고 싶은 경우
    // filter '내부'에서 maxBy 이용 [비효율적 코드] - 변하지 않는 최대값을 자료 수 만큼 구함
    peoples.filter { it.age == peoples.maxByOrNull(Person::age)!!.age }

    // filter '외부'에서 maxBy 이용 [효율적 코드]
    val maxAge = peoples.maxByOrNull(Person::age)!!.age
    val maxAgePeople = peoples.filter { it.age == maxAge }
    println(maxAgePeople)
}

fun mapToMap() {
    val numbers = mapOf(1 to "zero", 2 to "one")
    // key는 제곱수로, value는 대문자로 변환
    val newMap = numbers.mapValues { it.value.uppercase() }.mapKeys { it.key * it.key }
    newMap.forEach {
        println("${it.key} - ${it.value}")
    }
}


fun allAnyTest() {
    // 조건에 만족하는지 검사하는 Predicate 계열의 함수
    val under30 = { p: Person -> p.age < 30 }

    //모든 원소가 만족하는지 판단하려면 all 함수를 사용
    val people3 = listOf(Person("안드로이드", 25), Person("코틀린", 33))
    println(people3.all(under30))

    //하나라도 만족하는 원소가 있는지 판단하려면 any 함수를 사용
    println(people3.any(under30))
}

fun countTest() {
    val under30 = { p: Person -> p.age < 30 }

    val people5 = listOf(Person("안드로이드", 25), Person("코틀린", 33))
    println(people5.count(under30))
}

fun findTest() {
    val under40 = { p: Person -> p.age < 40 }
    val people7 = listOf(Person("안드로이드", 25), Person("코틀린", 33))
    println(people7.find(under40))

    val under10 = { p: Person -> p.age < 10 }
    println(people7.find(under10))
}

fun groupByTest() {
    val people8 = listOf(
        Person("안드로이드", 25),
        Person("코틀린", 30),
        Person("자바", 30)
    )
    val map = people8.groupBy { it.age }
    map.forEach {
        println("나이: ${it.key}, 구성원: ${it.value}")
    }
}


data class House(var name: String, var price: Long, var zone: String)

fun groupByTest2(){
    val house = listOf(
        House("압구정현대아파트",3000000000,"서울"),
        House("반포자이아파트", 700000000,"서울"),
        House("A아파트", 4000000000,"구미"),
        House("B아파트", 8000000000,"부산")
    )

    //지역별로 그룹을 나눠서 출력하세요
    val result1 = house.groupBy { it.zone }
    result1.forEach{
        println("지역: ${it.key}, 집: ${it.value}")
    }

    //40억 이상 아파트 필터링해서 그 아파트의 이름을 출력
    val result2 = house.filter { it.price >= 4000000000 }.map { it.name }
    println(result2)
}

//잘게 쪼개는 것
fun flatMapTest(){ 
    val strings = listOf("abc", "def")
    val newMap = strings.flatMap{ it.toList() }
    println(newMap)

    val nestedList = listOf(listOf("abc", "def"), listOf("hij", "klm"))
    val newMap2 = nestedList.flatMap{ it.toList() }
    println(newMap2)
    val newMap3 = nestedList.flatMap{ it }.flatMap { it.toList() }
    println(newMap3)
}

fun flattenTest(){
    val strings = listOf(listOf("abc", "def"), listOf("hij", "klm"))

    println(strings.flatten())
}

