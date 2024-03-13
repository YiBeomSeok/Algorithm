package codewars

fun nbYear(pp0: Int, percent: Double, aug: Int, p: Int): Int {

    generateSequence(pp0.toDouble()) { it * (1 + percent / 100) + aug }.takeWhile { it < p }.forEach { println(it) }
    return generateSequence(pp0.toDouble()) { it * (1 + percent / 100) + aug }.takeWhile { it < p }.count()
}