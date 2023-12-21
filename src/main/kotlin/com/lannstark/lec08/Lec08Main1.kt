package com.lannstark.lec08

// Lec08. 코틀린에서 함수를 다루는 방법
// 1. 함수 선언 문법
// 2. default parameter
// 3. named argument(paramater)
// 4. 같은 타입의 여러 파라미터 받기(가변인자)

fun max1(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else b
}
// 위 함수는 하나의 리턴문으로 끝나므로 아래처럼 =을 사용하여 간단하게 표현할 수 있음
// 또한 인자를 반환하므로 =을 쓰면 리턴 타입을 생략할 수 있음
fun max2(a: Int, b: Int) = if (a > b) a else b


// Java에서는 default parameter를 지원하지 않음
// Kotlin에서는 아래와 같이 default parameter를 설정 가능
fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}
// 그러면 repeat("Hello")처럼 num, useNewLine을 생략하고 호출하면 자동으로 num = 3, useNewLine = true로 설정됨
// 만약 num만 생략하고 싶다면 repeat("Hello", useNewLine = false)처럼 명시적으로 useNewLine을 설정해주면 됨
// 이것이 named argument(parameter)
// 또한 named argument는 순서를 바꿔서 사용할 수 있으며, 일부만 사용할 수도 있고, 생략할 수도 있음
// 빌더를 사용하는 것과 비슷하게 사용할 수 있음
// Java에서 가져온 함수를 사용할 때에는 named argument를 사용할 수 없음

// Java에서는 같은 타입의 여러 파라미터를 받을 때 아래와 같이 ...을 사용한 가변인자를 사용
//public static void printAll(String... strs) {
//    for (String str : strs) {
//        System.out.println(str);
//    }
//}
// Kotlin에서는 아래와 같이 vararg 키워드를 사용하여 가변인자를 사용
fun printAll(vararg strs: String) {
    for (str in strs) {
        println(str)
    }
}

fun main() {
    printAll("A", "B", "C")

    val array = arrayOf("A", "B", "C")
    // Java에서는 printAll(array)처럼 배열을 넘겨줘야 하지만, Kotlin에서는 *을 사용하여 전개(spread)하여 넘겨줘야 함
    printAll(*array)
}