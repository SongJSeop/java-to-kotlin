package com.lannstark.lec04

// Lec04. 코틀린에서 연산자를 다루는 방법
// 3. 논리 연산자와 코틀린에 있는 특이한 연산자

fun main() {
    // 논리 연산자(&&, ||, !)
    // 자바와 코틀린 완전 동일
    // 자바처럼 Lazy 연산 수행
    // Lazy 연산이란 "~~ || ~~" 등과 같은 상황에서 논리 연산자의 앞 부분이 true이면 뒷 부분은 수행하지 않는 것을 의미
    // "~~ && ~~" 등과 같은 상황에서 논리 연산자의 앞 부분이 false이면 뒷 부분은 수행하지 않는 것을 의미

    // in / !in - 컬렉션이나 범위에 포함되어 있다, 포함되어 있지 않다
    val numbers = listOf(1, 2, 3, 4, 5)
    println(1 in numbers) // true

    // a..b - a부터 b까지의 범위 객체를 생성
    val numbers2 = 1..10
    println(numbers2)  // 1..10 출력
    // 반복문에서 자주 쓰임
    for (i in 1..10) {
        println(i)
    }

    // a[i] - a라는 배열의 i번째 원소를 가져옴
    val numbers3 = listOf(1, 2, 3, 4, 5)
    println(numbers3[3]) // 4 출력
}