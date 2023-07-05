package com.lannstark.lec03

// Lec03. 코틀린에서 Type을 다루는 방법
// 4. String Interpolation, String Indexing

fun main() {

    val person = Person("최태현", 100)
    System.out.println(String.format("이름: %s", person.name))  // 자바에서는 이런 식으로
    println("이름: ${person.name}")  // 코틀린 방식
    val name = "최태현"
    println("이름: $name")  // 그냥 변수를 쓸 때는 중괄호 생략 가능
    // 그러나 가독성, 일괄 변환, 정규식 활용 등의 이유로 중괄호는 생략하지 않는 것이 좋음

    val str1 = """
        ABCD
        EFG
        ${name}
    """.trimIndent()  // 따옴표 3개로 이렇게 한 번에 입력 가능
    println(str1)

    val str2 = "ABCD"  // 문자열의 인덱싱
    println(str2[0])
    println(str2[2])
}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}