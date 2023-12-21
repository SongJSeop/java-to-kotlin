package com.lannstark.lec09

// Lec09. 코틀린에서 클래스를 다루는 방법
// 1. 클래스와 프로퍼티
// 2. 생성자와 init

// 아래는 Java에서의 예시 클래스
//public class JavaPerson {
//
//    private final String name;  // final이므로 setter가 없다.
//    private int age;
//
//    public JavaPerson(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public int getAge() {
//        return this.age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}

// 위 클래스를 Kotlin으로 변환하면 아래와 같다. public은 기본값으로 생략 가능
class Person(  // 생성자를 클래스 선언 부분에 작성
    // 생성자 파라미터에 val, var를 붙이면 프로퍼티로 선언된다.
    // val은 getter만 자동으로 생성되고, var는 getter와 setter가 자동으로 생성된다.
    val name: String,
    var age: Int
    ) {
}

fun main() {
    val person = Person("Lannstark", 27)
    // Java에서는 getter를 호출할 때 getName()과 같이 호출하지만, Kotlin에서는 프로퍼티처럼 호출한다.
    println(person.name)
    println(person.age)
    // Java에서는 setter를 호출할 때 setAge()와 같이 호출하지만, Kotlin에서는 프로퍼티처럼 호출한다.
    person.age = 28
    println(person.age)
    // Java에서 가져온 클래스를 Kotlin에서 사용할 때도 마찬가지로 프로퍼티처럼 사용할 수 있다.

    val person2 = Person2()
}

// 만약 생성자에 아래와 같은 검증 로직이 있다면?
//public JavaPerson(String name, int age) {
//    if (age < 0) {
//        throw new IllegalArgumentException("나이는 0보다 작을 수 없습니다.")
//    }
//    this.name = name;
//    this.age = age;
//}
// 클래스 선언부에 생성자를 사용하는 Kotlin의 경우 아래와 같이 작성할 수 있다.
class Person2(val name: String, var age: Int) {
    // init 블록은 생성자 호출 시점에 실행된다.
    // 여러 개의 init 블록을 사용할 수 있으며, 순서대로 실행된다.
    init {
        if (age < 0) {
            throw IllegalArgumentException("나이는 0보다 작을 수 없습니다.")
        }
    }

    // 만약 새로운 생성자를 추가하고 싶다면 아래와 같이 작성한다. (ex. 새로 태어난 아기의 경우 1살로 생성)
    constructor(name: String): this(name, 1)
    constructor(): this("익명") {  // 이렇게 부생성자에는 코드 블럭을 사용할 수 있다.
        println("익명의 나이는 1살입니다.")
    }
    // 생성자 코드 블럭은 위에서부터 순서대로 실행된다.(init -> 부생성자)
    // 코틀린에서는 부생성자보다는 default parameter를 사용하는 것을 권장한다.
}