package com.lannstark.lec06

// Lec06. 코틀린에서 반복문을 다루는 방법
// 1. for-each문
// 2. 전통적인 for문

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)  // 자바의 Array.asList(1, 2, 3, 4, 5)대신 listOf를 사용한다.
    for (number in numbers) {  // 자바의 ':' 대신 in 키워드를 사용한다.(Iterable이 구현된 객체에 한해서)
        println(number)
    }

    // 자바에서는 for (int i = 1; i <= 3; i++) { ... } 이런 식으로 사용
    for (i in 1..3) {  // 코틀린에서는 '..' 연산자를 사용하여 범위를 지정할 수 있음
        println(i)
    }

    for (i in 3 downTo 1) {  // 내려가는 경우에는 'downTo'를 사용
        println(i)
    }

    for (i in 1..5 step 2) {  // 2씩 증가하면서 반복
        println(i)
    }
}