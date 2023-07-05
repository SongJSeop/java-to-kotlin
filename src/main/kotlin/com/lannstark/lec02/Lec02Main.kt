package com.lannstark.lec02

// Lec02. 코틀린에서 null을 다루는 방법

fun main() {

    // 1. Safe Call
    val str1: String? = "ABC"
//    println(str.length)  // str에 null이 들어올 수 있으므로 바로 str.length는 불가능
    println(str1?.length)  // . 앞에 ?를 붙이면 앞의 변수가 null이면 자동으로 length 메서드를 실행하지 않음.

    // 2. Elvis
    val str2: String? = null
    println(str2?.length ?: 0)  // 만약 앞의 결과가 null이면 0을 반환
    // str2?.length의 값은 str2 값이 null이므로 Safe Call에 의해 length 메서드가 실행되지 않은 채 null 반환
    // 그 뒤 Elvis 연산자에 의해 null 값이 0이 됨


    // 3. 널 아님 단언 함수 테스트
    println(startsWithANoNull("B"))
//    println(startsWithANoNull(null))  // 그럼에도 불구하고 null이 들어온다면 컴파일 에러는 나지 않지만 런타임 에러가 발생
    // 정말 확실할 때만 !!를 붙여 널 아님 단언을 사용한다.


    // 4. 플랫폼 타입
    // 코틀린에서 자바 코드를 가져다 쓸때 어떠한 타입이 null이 될 수 있는지 없는지 어떻게 처리할까?
    // java package lec02에 있는 Person 클래스 참고(getName()메서드가 @Nullable 처리 되어있음)
    val person = Person("공부하는 개발자")
//    startsWithA(person.name)  // Person 클래스의 getName() 메서드가 null이 될 수 있기 때문에 컴파일 불가
    // 위처럼 코틀린에서 자바 코드를 쓸때는 null에 대한 어노테이션 정보를 코틀린이 이해함.
    // @Nullable을 @NotNull로 수정하면 사용 가능.
    // 그러나 어노테이션 정보가 없다면 변수가 null인지 아닌지 알 수 없음 -> 이게 바로 플랫폼 타입
    // 그래서 일단 실행하고 null이면 런타임 에러.
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


// 위의 3가지 함수를 코틀린스럽게 바꾸기
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

// null 아님 단언: 아무리 생각해도 null이 될 수 없을 때
// 이렇게 !!를 붙여 단언. 함수 리턴 타입에 ?를 붙이지 않아도 됨
fun startsWithANoNull(str: String?): Boolean {
    return str!!.startsWith("A")
}

// 플랫폼 타입 점검 용 함수
fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}