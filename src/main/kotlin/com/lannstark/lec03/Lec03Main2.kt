package com.lannstark.lec03

// Lec03. 코틀린에서 Type을 다루는 방법
// 2. 타입 캐스팅

fun main() {
    // 기본 타입이 아닌 일반 타입의 변환은?
    printAgeIfPerson1(Person("", 100))
    printAgeIfPerson2(null)  // null 출력
}

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