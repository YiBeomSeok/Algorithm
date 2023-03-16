package coding_interview.bitmask

const val MAX = 16
const val INF = 1_000_000_000
val W = Array(MAX) { IntArray(MAX) }
val dp = Array(MAX) { IntArray(1 shl MAX) { -1 } }

fun tsp(current: Int, visited: Int, n: Int): Int {
    if (visited == (1 shl n) - 1) {
        return if (W[current][0] != 0) W[current][0] else INF
    }

    if (dp[current][visited] != -1) {
        return dp[current][visited]
    }

    var minCost = INF
    for (next in 0 until n) {
        if (W[current][next] != 0 && (visited and (1 shl next)) == 0) {
            minCost = minOf(minCost, W[current][next] + tsp(next, visited or (1 shl next), n))
        }
    }

    dp[current][visited] = minCost
    return minCost
}

fun main() {
    val n = 4
    W[0] = intArrayOf(0, 10, 15, 20)
    W[1] = intArrayOf(5, 0, 9, 10)
    W[2] = intArrayOf(6, 13, 0, 12)
    W[3] = intArrayOf(8, 8, 9, 0)

    println(tsp(0, 1, n)) // 출력: 35
}