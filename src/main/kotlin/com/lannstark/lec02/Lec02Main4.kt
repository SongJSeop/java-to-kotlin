package com.lannstark.lec02

// Lec02. 코틀린에서 null을 다루는 방법
// 4. 플랫폼 타입

fun main() {
    // 코틀린에서 자바 코드를 가져다 쓸때 어떠한 타입이 null이 될 수 있는지 없는지 어떻게 처리할까?
    // java package lec02에 있는 Person 클래스 참고(getName()메서드가 @Nullable 처리 되어있음)
    val person = Person("공부하는 개발자")
//    startsWithA(person.name)  // Person 클래스의 getName() 메서드가 null이 될 수 있기 때문에 컴파일 불가
    // 위처럼 코틀린에서 자바 코드를 쓸때는 null에 대한 어노테이션 정보를 코틀린이 이해함.
    // @Nullable을 @NotNull로 수정하면 사용 가능.
    // 그러나 어노테이션 정보가 없다면 변수가 null인지 아닌지 알 수 없음 -> 이게 바로 플랫폼 타입
    // 그래서 일단 실행하고 null이면 런타임 에러.
}

fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}