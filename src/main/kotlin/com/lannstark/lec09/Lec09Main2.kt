package com.lannstark.lec09

// Lec09. 코틀린에서 클래스를 다루는 방법
// 3. 커스텀 getter, setter
// 4. backing field

class Person3(
    name: String = "송준섭",  // 커스텀 getter를 만들기 위해서 val, var를 붙이지 않는다.
    var age: Int = 1
) {
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 0보다 작을 수 없습니다.")
        }
    }

    val name: String = name  // 생성자에서 받은 name을 name 프로퍼티에 저장
        get() = field.uppercase()  // name.uppercase()라고 작성하면 name 프로퍼티를 또 get() 하여 무한루프에 빠짐
    // field는 자기 자신 프로퍼티의 값을 저장하는 변수(backing field라고도 부름), 밖에서 호출 시 uppercase() 메서드를 사용하였으므로 대문자로 변환하여 리턴

    // 사실 보통 커스텀 getter를 만들지 않고, 아래와 같은 방법으로 사용
//     val upperCaseName: String
//         get() = this.name.uppercase()

    // 커스텀 setter도 만들 수 있음 -> 잘 안쓰임, 차라리 메서드로 정의하는 방법이 추천됨
    // val name = name
    //   set(valud) {
    //       field = value.uppercase()
    //   }

    // 아래와 같이 isAudlt() 메서드를 만들어서 사용할 수도 있음
//    fun isAdult(): Boolean {
//        return age >= 20
//    }

    // 이렇게 커스텀 getter로 직접 정의한 프로퍼티처럼 사용할 수도 있음
    val isAdult: Boolean
        get() {
            return this.age >= 20
        }
    //  get() = this.age >= 20  // 위와 같은 코드
    // 보통 객체의 속성을 나타내는 거라면 커스텀 getter로, 그렇지 않으면 메서드로 정의
}
