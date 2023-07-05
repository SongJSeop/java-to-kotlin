package com.lannstark.lec02

// Lec02. 코틀린에서 null을 다루는 방법
// 3. 널 아님 단언

fun main() {
    // 널 아님 단언: 아무리 생각해도 null이 될 수 없을 때
    println(startsWithANoNull("B"))
//    println(startsWithANoNull(null))  // 그럼에도 불구하고 null이 들어온다면 컴파일 에러는 나지 않지만 런타임 에러가 발생
    // 정말 확실할 때만 !!를 붙여 널 아님 단언을 사용한다.
}

// 이렇게 !!를 붙여 단언. 함수 리턴 타입에 ?를 붙이지 않아도 됨
fun startsWithANoNull(str: String?): Boolean {
    return str!!.startsWith("A")
}