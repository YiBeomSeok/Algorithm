package inflearn.kotlin.ch10

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    val coins = IntArray(n) { st.nextToken().toInt() }

    val m = br.readLine().toInt()

    coins.sort()

    val dp = IntArray(m + 1) { Int.MAX_VALUE }
    dp[0] = 0
    for(i in 0 until n) {
        for(j in coins[i] .. m) {
            dp[j] = minOf(dp[j], dp[j - coins[i]] + 1)
        }
    }

    print(dp[m])
}