package com.ssafy.kotlin

class A<T>
class B<out T>
class C<in T>

fun main() {
    //T 로 선언된 경우
    val a: A<Int> = A<Int>() // 양쪽 자료형 일치해야 함.

    //out T 로 선언된 경우
    val b1: B<Number> = B<Number>(); // 양쪽 자료형 일치 -> OK
    val b2: B<Number> = B<Int>(); // 왼쪽이 Super 면 -> OK
//    val b3: B<Int> = B<Number>(); // 왼쪽이 Sub 면 -> 컴파일 오류

    //in T 로 선언된 경우
    val c1: C<Number> = C<Number>() // 양쪽 자료형 일치 -> OK
    val c2: C<Int> = C<Number>() // 오른쪽이 Super면 -> OK
//    val c3: C<Number> = C<Int>() // 오른쪽이 Sub 면 -> 컴파일 오류

    /* <*> 은 상관없이 대응 */
    val star1: A<*> = A<Number>()
    val star2: A<*> = A<Int>()
    val star3: A<*> = A<String>()
}


