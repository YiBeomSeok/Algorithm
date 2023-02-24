package boostcourse.chap04.section1

/**
 * 변수를 함수처럼 사용 가능
 */
fun main() {
    val result: Int

    // val multi = { a, b ->  } // {람다 함수에 사용할 매개변수 -> 반환할 식}
    // a, b가 뭔지 모름

    val multi1 = { a: Int, b: Int -> a * b }
    val multi2: (a: Int, b: Int) -> Int = { a, b ->
        println("a: $a, b: $b")
        a * b // 마지막 식이 반환 타입과 동일해야 함
    } // 매개변수에 자료형 생략

    result = multi2(10, 20)
    println(result)

    /**
     * 반환 자료형이 없거나 매개변수가 하나 있을 때
     */
    val greet: () -> Unit = { println("Hello") }
    val square: (Int) -> Int = { x -> x * x }

    /**
     * 람다식 안에 람다식이 있는 경우
     */
    val nestedLambda: () -> () -> Unit = {
        { println("nestedLambda") }
    }

}
