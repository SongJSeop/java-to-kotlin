package com.lannstark.lec10

abstract class Animal(  // abstract 키워드를 붙이면 추상 클래스 -> 인스턴스화 불가능
    protected val species: String,
    protected open val legCount: Int,
) {

    abstract fun move()

}