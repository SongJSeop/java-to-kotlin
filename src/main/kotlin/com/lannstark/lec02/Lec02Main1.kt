package com.lannstark.lec02

// Lec02. 코틀린에서 null을 다루는 방법
// 1. Safe Call

fun main() {

    val str1: String? = "ABC"
//    println(str.length)  // str에 null이 들어올 수 있으므로 바로 str.length는 불가능
    println(str1?.length)  // . 앞에 ?를 붙이면 앞의 변수가 null이면 자동으로 length 메서드를 실행하지 않음.
}