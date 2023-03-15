package inflearn.kotlin.ch08

import java.io.*
import java.util.*

class Swapper(val n: Int, val m: Int, var kinds: IntArray) {
    var min = Integer.MAX_VALUE

    fun findMin(): Int {
        kinds = kinds.sortedArrayDescending()
        dfs(0, 0)

        return min
    }
    fun dfs(depth: Int, sum: Int) {
        if (sum > m) return
        if (depth > min) return

        if (sum == m) {
            min = min.coerceAtMost(depth)
        } else {
            for (i in 0 until n) {
                dfs(depth + 1, sum + kinds[i])
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    val kinds = IntArray(n)
    for (i in 0 until n) {
        kinds[i] = st.nextToken().toInt()
    }

    val m = br.readLine().toInt()

    val swapper = Swapper(n, m, kinds)
    println(swapper.findMin())
}