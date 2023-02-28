package boostcourse.chap05.section3

fun main() {
    retFunc()
}

inline fun inLineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun retFunc() {
    println("Start of Func")
    inLineLambda(12, 3) { a, b ->
        val result = a + b
        if (result > 10) return@inLineLambda
        println(result)
    }
    println("end of Func")
}