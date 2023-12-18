package com.lannstark.lec04

// Lec04. 코틀린에서 연산자를 다루는 방법
// 4. 연산자 오버로딩

fun main() {
    // 코틀린에서는 객체마다 연산자를 직접 오버로딩하여 정의할 수 있음
    val money1 = JavaMoney(2000L)
    val money2 = JavaMoney(1000L)
    // 자바에서는 println(money1.plus(money2))와 같이 메서드를 호출해야 하지만 코틀린에서는 아래와 같이 연산자를 사용할 수 있음
    println(money1 + money2)  // 3000 출력
}
