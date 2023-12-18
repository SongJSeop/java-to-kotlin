package com.lannstark.lec05

// Lec05. 코틀린에서 조건문을 다루는 방법
// 3. switch와 when

fun main() {

}

fun getGradeWithSwitch(score: Int): String {
    return when (score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
    // 아래와 같음
//    return when (score) {
//        in 90..99 -> "A"
//        in 80..89 -> "B"
//        in 70..79 -> "C"
//        else -> "D"
//    }
}

fun startsWithA(obj: Any): Boolean {
    // is 연산자를 사용하여 타입을 체크할 수 있음
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(num: Int): String {
    return when (num) {
        1, 0, -1 -> "Known number"
        else -> "Unknown"
    }
}

fun judgeNumber2(num: Int): String {
    return when {
        num == 0 -> "Zero"
        num % 2 == 0 -> "Even number"
        else -> "Odd number"
    }
}