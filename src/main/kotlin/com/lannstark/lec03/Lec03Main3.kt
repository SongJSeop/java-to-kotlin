package com.lannstark.lec03

// Lec03. 코틀린에서 Type을 다루는 방법
// 3. 코틀린의 3가지 특이한 타입

fun main() {

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
}