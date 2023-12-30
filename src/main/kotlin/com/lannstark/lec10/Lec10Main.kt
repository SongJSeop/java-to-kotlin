package com.lannstark.lec10

fun main() {
    val derived = Derived(10)
    // 실행하면 Base class의 init이 먼저 실행되고, Derived class의 init이 실행된다.
    // 이 때 Base class의 init에서 number 출력한 값이 100도, 10도 아닌 0이 출력된다.
    // Derived 인스턴스화를 할 때 number에 값을 넣어줘야 함
    // 이 때 상위 클래스에서 number를 prinln할 때 하위 클래스의 number를 가져와야 함
    // 근데 아직 Derived 클래스의 number 변수 초기화가 끝나지 않았기 때문에 Int의 기본값인 0이 출력된다.
    // 즉, 상위 클래스의 init에서 하위 클래스의 field에 접근하면 안된다. (final이면 상관 없음)
    // 상위 클래스를 설계할 때 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open을 피해야 함
}

open class Base(  // open 키워드를 붙여야 상속이 가능하다.
    open val number: Int = 100  // open 키워드를 붙여야 오버라이딩이 가능하다.
) {
    init {
        println("Base Class")
        println(number)
    }
}

class Derived(
    override val number: Int
) : Base(number) {
    init {
        println("Derived Class")
    }
}

// 상속 관련 키워드들
// 1. final: override를 막는다. default로 보이지 않게 존재
// 2. open: 상속이 가능하다. override를 허용한다.
// 3. abstract: 추상 클래스로 만든다. 반드시 override 해야 한다.
// 4. override: 상위 클래스의 메소드를 하위 클래스에서 재정의한다.