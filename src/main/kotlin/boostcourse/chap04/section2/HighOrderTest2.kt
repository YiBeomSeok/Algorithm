package boostcourse.chap04.section2

fun highOrder(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}

fun main() {
    val a = 3
    val b = 3
    val result = highOrder({x, y -> x + y}, a, b)
}