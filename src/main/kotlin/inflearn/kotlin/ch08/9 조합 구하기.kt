package inflearn.kotlin.ch08

import java.io.*
import java.util.*

class CombinationFinder {
    lateinit var combi: IntArray
    var n = 0
    var m = 0

    fun solution(n: Int, m: Int) {
        this.n = n
        this.m = m

        combi = IntArray(m)

        dfs(0, 1)
    }

    private fun dfs(depth: Int, start: Int) {
        if (depth == m) {
            combi.forEach {
                print("$it ")
            }
            println()
        } else {
            for (number in start..n) {
                combi[depth] = number
                dfs(depth + 1, number.inc())
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val finder = CombinationFinder()
    finder.solution(n, m)
}