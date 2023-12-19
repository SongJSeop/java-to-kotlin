package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

// Lec07. 코틀린에서 예외을 다루는 방법
// 1. try-catch-finally 구문
// 2. Checked Exception과 Unchecked Exception
// 3. try-with-resources 구문

fun main() {
    // try-catch-finally 구문은 자바와 완전 동일
    println(parseIntOrThrow("1"))
//    println(parseIntOrThrow("A"))

    readFile();
    readFile2("./a.txt");
}

fun parseIntOrThrow(str: String): Int {
    return try {
        str.toInt()  // 자바에서는 Integer.parseInt(str)을 사용
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자가 아닌 문자열이 입력되었습니다.")
    } finally {
        println("finally 블록이 실행되었습니다.")
    }
}

// 자바에서는 파일을 읽을 때 다음과 같이 코드를 작성
// 예외가 발생할 수 있으므로 throws IOException을 작성해야 함
//public void readFile() thorws IOException {
//    File currentFile = new File(".");
//    File file = new File(currentFile.getAbsolutePath() + "/a.txt");
//    BufferedReader reader = new BufferedReader(new FileReader(file));
//    System.out.println(reader.readLine());
//    reader.close();
//}

// kotlin에서는 Checked Exception 처리, 즉 throws IOException을 작성하지 않아도 됨
// kotlin에서는 Checked Exception과 Unchecked Exception을 구분하지 않음
// 모두 Unchecked Exception으로 처리
fun readFile() {
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(file.reader())
    println(reader.readLine())
    reader.close()
}

// try-with-resources 구문은 자바와 완전 동일
// 자바에서는 try-with-resources 구문을 사용하면 자동으로 close()를 호출해줌
// 알아서 외부 자원을 닫아주는 것
//public void readFile2(String path) throws IOException {
//    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//        System.out.println(reader.readLine());
//    }
//}

// kotlin에서는 try-with-resources 구문이 사라지고 use라는 inline 확장 함수를 사용
fun readFile2(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}