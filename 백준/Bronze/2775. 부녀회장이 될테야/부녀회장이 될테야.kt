var apt = Array(15) { IntArray(15) }
fun main(args: Array<String>) {
    val T = readln().toInt()

    for (i in 0 until T) {
        val k = readln().toInt()
        val n = readln().toInt()

        println(countPerson(k, n))
    }
}

fun countPerson(k: Int, n: Int): Int {
    if (apt[k][n] != 0)
        return apt[k][n]

    if (k == 0) {
        apt[k][n] = n
        return n
    }
    if (n == 1) {
        apt[k][n] = 1
        return 1
    }
    return countPerson(k, n - 1) + countPerson(k - 1, n)
}