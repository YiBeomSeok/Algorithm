package inflearn.kotlin.ch08

import java.io.*
import java.util.*

class MaxScoreFinder(val size: Int, val limit: Int, val info: Array<IntArray>) {

    var max = 0

    fun getMaxScoreAtLimitTime(): Int {
        dfs(0, 0, 0)
        return max
    }

    fun dfs(score: Int, time: Int, depth: Int) {
        if(time > limit) return

        if(depth == size) {
            max = max.coerceAtLeast(score)
        } else {
            dfs(score + info[depth][0], time + info[depth][1], depth + 1)
            dfs(score, time, depth + 1)
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val info = Array(n) { IntArray(2) }

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        info[i][0] = st.nextToken().toInt()
        info[i][1] = st.nextToken().toInt()
    }

    val finder = MaxScoreFinder(n, m, info)
    println(finder.getMaxScoreAtLimitTime())
}

/*
5 20
10 5
25 12
15 8
6 3
7 4

-> 41
 */