package com.lannstark.lec03

import kotlin.reflect.typeOf

// Lec03. 코틀린에서 Type을 다루는 방법

fun main() {

    // 1. 기본 타입
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


    // 2. 타입 캐스팅
    // 기본 타입이 아닌 일반 타입의 변환은?
    printAgeIfPerson1(Person("", 100))
    printAgeIfPerson2(null)  // null 출력


    // 3. 코틀린의 3가지 특이한 타입

    /* Any
    Java의 Object 역할(모든 객체의 최상위 타입)
    모든 기본형의 최상위 타입이기도 함
    Any 자체로는 null을 포함할 수 없어 null을 포함하고 싶다면 Any?로 표현
    Any에 equals / hasCode / toString 존재
     */

    /* Unit
    Java의 void와 동일한 역할
    void와 다르게 Unit은 그 자체로 타입 인자로 사용 가능
    함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미
    즉, 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현
     */

    /* Nothing
    함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
    무조건 예외를 반환하는 함수 / 무한 루프 함수 등
    밑의 fail 함수가 예시
    실제로 많이 쓰이지는 않음
     */


    // 4. String Interpolation, String Indexing
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


// 타입 캐스팅용 함수
fun printAgeIfPerson1(obj: Any) {
    if (obj is Person) {  // is는 자바의 instanceof. 만약 !is면 obj가 Person이 아니라면 이라는 뜻
        val person = obj as Person  // obj as Person는 자바의 (Person) obj와 같음.
        println(person.age)
        // 사실 위 두줄을 println(obj.age)라고 해도 결과는 같음. 스마트 캐스트 라고 함.
        // is Person으로 타입 체크를 했다고 간주하고 obj를 Person으로 생각함
    }
}
// 만약 obj as Person에서 obj가 Person이 아니었다면 ClassCastException 발생

// obj에 null이 들어올 수 있다면
fun printAgeIfPerson2(obj: Any?) {
    val person = obj as Person?  // Person에 ?을 붙임. obj가 null이라면 person 변수는 null이 됨
    println(person?.age)  // person이 null이면 실행되지 않고 null 반환
}
// 만약 obj as? Person 이라면?
// obj가 Person Type => Person으로 형변환
// obj가 null => null
// obj가 Person Type이 아님 => null
// 안전한 형변환이라고 생각하면 좋을 듯 함


fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}