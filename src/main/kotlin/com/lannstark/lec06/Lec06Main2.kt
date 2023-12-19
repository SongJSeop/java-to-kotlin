package com.lannstark.lec06

// Lec06. 코틀린에서 반복문을 다루는 방법
// 3. Progression과 Range
// 4. while문

fun main() {
    // '..' 연산자는 범위를 만들어내는 연산자
    // 범위는 Range라는 실제 클래스가 있음
    // Range는 등차수열인 Progression을 상속받고 있음
    // 3 downTo 1: 시작값 3, 끝값 1, 공차가 -1인 등차수열
    // 1..5 step 2: 시작값 1, 끝값 5, 공차가 2인 등차수열
    // 1..5로 등차수열을 만든 후 step 함수를 호출하여 공차를 2로 바꿈
    // 여기서 step와 같이 '.' 또는 '()'를 사용하지 않고 호출하는 함수를 중위함수(infix function)라고 부름

    // while문은 자바와 완전 동일
    var i = 0  // i가 증가해야하므로 var로 선언
    while (i < 3) {
        println(i)
        i++
    }
}