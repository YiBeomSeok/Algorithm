import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val T = sc.nextInt()

    for (i in 0 until T) {
        val n = sc.nextInt()
        val memo = Array(n + 1) { IntArray(2) }

        for (j in 0..n) {
            when (j) {
                0 -> memo[0] = intArrayOf(1, 0)
                1 -> memo[1] = intArrayOf(0, 1)
                else -> {
                    memo[j][0] = memo[j - 1][0] + memo[j - 2][0]
                    memo[j][1] = memo[j - 1][1] + memo[j - 2][1]
                }
            }
        }

        println("${memo[n][0]} ${memo[n][1]}")
    }
}
