package inflearn.kotlin.ch10

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    val arr = IntArray(n)
    val dp = IntArray(n)

    for(i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }
    dp[0] = 1

    var answer = 1
    for(i in 1 until n) {
        var max = 0
        for(j in i - 1 downTo 0) {
            if(arr[j] < arr[i]) {
                max = maxOf(max, dp[j])
            }
        }
        dp[i] = max + 1
        answer = maxOf(answer, dp[i])
    }

    print(answer)
}