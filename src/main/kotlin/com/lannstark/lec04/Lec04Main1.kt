package com.lannstark.lec04

// Lec04. 코틀린에서 연산자를 다루는 방법
// 1. 단항 연산자 / 산술 연산자
// 2. 비교 연산자와 동등성, 동일성

fun main() {
    // 단항 연산자(++, --)
    // 산술 연산자(+, -, *, /, %)
    // 산술 대입 연산자(+=, -=, *=, /=, %=)
    // 자바와 코틀린 완전 동일

    // 비교 연산자(>, <, >=, <=)
    // 자바와 코틀린 사용법 동일
    // 그러나 코틀린에서는 자바와 다르게 객체를 비교할 때 비교 연산자를 사용하면 자동으로 compareTo를 호출
    val money1 = JavaMoney(2000L)
    val money2 = JavaMoney(1000L)
    if (money1 > money2) {
        println("money1이 money2보다 크다.")
    }
    // 위의 ">" 부분을 Command + 클릭하면 compareTo 메서드로 이동

    // 동등성: 두 객체의 값이 같은가 - "=="으로 확인 (자바에서 equals 사용)
    // 코틀린에서는 == 연산자를 사용하면 자동으로 equals 메서드를 호출
    // 동일성: 두 객체가 같은 객체인가 - "==="으로 확인 (자바에서 == 사용)
    val money3 = JavaMoney(2000L)
    println(money1 == money3)  // 값이 같으므로 true, "=="를 Command + 클릭하면 equals 메서드로 이동
    println(money1 === money3)  // 다른 객체이므로 false
}