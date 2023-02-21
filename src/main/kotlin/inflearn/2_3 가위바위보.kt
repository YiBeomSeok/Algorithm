package inflearn

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.security.InvalidParameterException
import java.util.*

object `2_3 가위바위보` {
    @Throws(InvalidParameterException::class)
    private fun match(a: Int, b: Int): String {
        if (a == 1) {
            if (b == 1) return "D" else if (b == 2) return "B" else if (b == 3) return "A"
        } else if (a == 2) {
            if (b == 1) return "A" else if (b == 2) return "D" else if (b == 3) return "B"
        } else if (a == 3) {
            if (b == 1) return "B" else if (b == 2) return "A" else if (b == 3) return "D"
        }
        throw InvalidParameterException()
    }

    fun solution(inputA: IntArray, inputB: IntArray): List<String> {
        val answer: MutableList<String> = ArrayList()
        val len = inputA.size
        for (i in 0 until len) {
            answer.add(match(inputA[i], inputB[i]))
        }
        return answer
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val inputA = IntArray(n)
        val inputB = IntArray(n)
        val stA = StringTokenizer(br.readLine())
        val stB = StringTokenizer(br.readLine())
        for (i in 0 until n) {
            inputA[i] = stA.nextToken().toInt()
            inputB[i] = stB.nextToken().toInt()
        }
        val ans = solution(inputA, inputB)
        for (result in ans) {
            println(result)
        }
    }
}