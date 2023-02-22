package inflearn

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

object `2_4 피보나치수열` {
    fun solution(n: Int): List<Int> {
        val fib = IntArray(n)
        fib[0] = 1
        fib[1] = 1
        for (i in 2 until n) {
            fib[i] = fib[i - 1] + fib[i - 2]
        }
        return fib.toList()
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val input = br.readLine().toInt()
        for (elem in solution(input)) {
            print("$elem ")
        }
    }
}