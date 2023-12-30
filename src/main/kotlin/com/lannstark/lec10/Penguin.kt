package com.lannstark.lec10

class Penguin(
    species: String
) : Animal(species, 2) {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 물을 헤엄칩니다.")
    }

    override val legCount: Int  // Animal의 legCount 프로퍼티에 open을 붙여야 override가 가능함
        get() = super.legCount + this.wingCount  // super를 사용하면 부모 클래스의 프로퍼티에 접근할 수 있다.
}