package inflearn.kotlin.ch10

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val dp = IntArray(n + 2)
    dp[1] = 1
    dp[2] = 2


    for(i in 3 .. n + 1) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    print(dp[n + 1])
}