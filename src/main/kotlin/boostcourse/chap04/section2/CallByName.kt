package boostcourse.chap04.section2

fun callByName(b: () -> Boolean): Boolean {
    println("callByName function")
    return b()
}

val otherLambda: () -> Boolean = {
    println("otherLambda function")
    true
}

fun main() {
    val result = callByName(otherLambda)
    println(result)

    /**
     * 안 되는 코드
     */
    /*
    fun sum(x: Int, y: Int) = x + y

    funcParam(3, 2, sum) // sum은 람다식이 아니다.
    ...
    fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
        return c(a, b)
    }
     */

    /**
     * 되는 것
     */

    fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
        return c(a, b)
    }

    funcParam(3, 2, ::sum) // 더블 콜론, 일반 함수의 내용물이 람다식의 파라미터 내용과 리텁타입이 같다면 가능
    // 참조 방식이라 한다.!!
}



