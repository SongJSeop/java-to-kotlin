package com.lannstark.lec10

class Cat(
    species: String
) : Animal(species, 4) {  // kotlin에서 상속은 ':'를 사용한다.

    override fun move() {
        println("고양이가 달립니다.")
    }
}