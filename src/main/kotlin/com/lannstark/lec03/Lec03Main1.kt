package com.lannstark.lec03

// Lec03. 코틀린에서 Type을 다루는 방법
// 1. 기본 타입

fun main() {

    // 기본 타입은 자바와 동일하게 Byte, Short, Int, Long, Float, Double, 부호 없는 정수들(unsigned) 존재
    val number1 = 1  // 앞서 말했듯 코틀린은 타입을 추론. 초기화된 값을 보고 타입을 추론. 이것은 Int로 추론됨
    val number2 = 1L  // 이것은 Long으로 추론
    val number3 = 3.0f  // Float로 추론
    val number4 = 3.0  // Double로 추론


    // 자바에서는 기본 타입간의 형변환이 암시적으로 이루어짐
    /*
    int number1 = 4;
    long number2 = number1;
    System.out.println(number1 + number2);
    int 타입이 long 타입(더 큰 타입)으로 암시적 변경
     */

    // 코틀린에서는 명시적으로 이루어져야 함
    val number11 = 4
//    val number12: Long = number11  // 이렇게 하면 컴파일 에러.
    val number12: Long = number11.toLong()  // 이렇게 명시적 형변환이 필요

    val number13 = 3
    val number14 = 5
    val result1 = number13 / number14  // Int와 Int의 나눗셈 -> result도 Int로 값이 0이 됨
    println(result1)
    val result2 = number13 / number14.toDouble()  // 한 쪽을 Double로 바꿔주면 result도 Double. 값은 0.6
    println(result2)


    // 변수가 nullable이라면 적절한 처리가 필요함
    val number21: Int? = 3
//    val number22: Long = number21.toLong()  // number21이 null일수도 있으므로(NullPointException 방지)
    val number22: Long = number21?.toLong() ?: 0L  // number21이 null일 수도 있으므로 null일 경우 0L이 할당되도록 처리.
}