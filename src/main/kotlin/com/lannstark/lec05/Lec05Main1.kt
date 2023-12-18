package com.lannstark.lec05

// Lec05. 코틀린에서 조건문을 다루는 방법
// 1. if문
// 2. Expression & Statement

fun main() {

}

fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {  // 자바와 if문 사용법이 같음
        // 자바와 달리 new를 사용하지 않음
        throw IllegalArgumentException("Score must be greater than 0")
    }

    if (score !in 0..100) {  // (0 <= score && score <= 100)를 이와 같이 간단하게 변경 가능
        throw IllegalArgumentException("Score must be between 0 and 100")
    }
}

fun getPassOrFail(score: Int): String {
    // 사용법은 비슷해 보임
    // 자바에서 if-else는 statement이지만 코틀린에서는 expression임
    // statement: 프로그램의 문장, 하나의 값으로 도출되지 않음
    // expression: 하나의 값으로 도출됨
    // 그래서 자바와 달리 if-else문이 하나의 값으로 도출되므로 변수에 할당할 수 있고, 바로 리턴할 수도 있음
    return if (score >= 50) {
        "Pass"
    } else {
        "Fail"
    }
    // 자바였다면 return score >= 50 ? "Pass" : "Fail"; 이렇게 쓰는 것과 비슷
    // 코틀린에서는 if-else문이 하나의 값으로 도출되므로 삼항 연산자가 필요 없음
}