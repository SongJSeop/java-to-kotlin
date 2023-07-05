package com.lannstark.lec02

// Lec02. 코틀린에서 null을 다루는 방법
// 2. Elvis

fun main() {

    val str2: String? = null
    println(str2?.length ?: 0)  // 만약 앞의 결과가 null이면 0을 반환
    // str2?.length의 값은 str2 값이 null이므로 Safe Call에 의해 length 메서드가 실행되지 않은 채 null 반환
    // 그 뒤 Elvis 연산자에 의해 null 값이 0이 됨
}

// str이 "A"로 시작하는지 알려주는 함수
// 함수의 인자에는 null이 들어올 수 있으니 물음표를 붙여준다.(코틀린에서는 ?가 붙은 타입은 완전히 다른 타입으로 간주한다.)
// 함수 이름 옆에 함수의 리턴 타입도 지정해준다.
fun startsWithA1(str: String?): Boolean {
    if (str == null) {
        throw  IllegalArgumentException("null이 들어왔습니다.")
    }
    return str.startsWith("A")
}

// 아래 함수는 null을 반환할수도 있으니 함수 리턴 타입에 물음표
fun startsWithA2(str: String?): Boolean? {
    if (str == null) {
        return null
    }
    return str.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    if (str == null) {
        return false
    }
    return str.startsWith("A")
}

// 위의 3가지 함수를 코틀린스럽게 Safe Call과 Elvis를 활용하여 바꾸기
fun startsWithA1Refactor(str: String?): Boolean {
    // str은 null이 들어갈 수 있다.
    // str.startsWith("A")의 결과가 null이면 IllegalArgumentException
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다.")
}

fun startsWithA2Refactor(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3Refactor(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}