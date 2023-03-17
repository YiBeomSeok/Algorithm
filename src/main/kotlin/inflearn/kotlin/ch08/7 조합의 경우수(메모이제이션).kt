package inflearn.kotlin.ch08

import java.io.*
import java.util.*

class Combination {
    val memo = Array(35) { IntArray(35) { 0 } }

    fun solution(n: Int, r: Int): Int {
        var answer = 0

        return combination(n, r)
    }

    private fun combination(n: Int, r: Int): Int {
        if(memo[n][r] > 0) return memo[n][r]

        if (r == 0) {
            return 1
        } else if (n == r) {
            return 1
        }
        else {
            memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r)
            return memo[n][r]
        }

    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val com = Combination()

    val st = StringTokenizer(br.readLine())

    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    println(com.solution(a, b))
}