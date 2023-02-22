package inflearn

import java.util.*

object `2_9 격자판 최대합` {
    fun solution(ints: Array<IntArray>): Int {
        var answer = Int.MIN_VALUE
        var sum1: Int
        var sum2: Int
        val n = ints.size
        for (i in 0 until n) {
            sum2 = 0
            sum1 = sum2
            for (j in 0 until n) {
                sum1 += ints[i][j]
                sum2 += ints[j][i]
            }
            answer = answer.coerceAtLeast(sum1)
            answer = answer.coerceAtLeast(sum2)
        }
        sum2 = 0
        sum1 = sum2
        for (i in 0 until n) {
            sum1 += ints[i][i]
            sum2 += ints[i][n - 1 - i]
        }
        answer = answer.coerceAtLeast(sum1)
        answer = answer.coerceAtLeast(sum2)
        return answer
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextLine().toInt()
        val input = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            val st = StringTokenizer(sc.nextLine())
            for (j in 0 until n) {
                input[i][j] = st.nextToken().toInt()
            }
        }
        println(solution(input))
    }
}