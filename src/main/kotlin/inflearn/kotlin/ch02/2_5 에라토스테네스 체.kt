package inflearn.kotlin.ch02

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * 이펙티브 코틀린에서 다룬 방식이 더 깔끔함
 */
object `2_5 에라토스테네스 체` {
    fun solution(n: Int): Int {
        var answer = 0
        val ch = IntArray(n + 1)
        for (i in 2..n) {
            if (ch[i] == 0) {
                answer++
                var j = i
                while (j <= n) {
                    ch[j] = 1
                    j += i
                }
            }
        }
        return answer
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val input = br.readLine().toInt()
        print(solution(input))
    }
}