package inflearn.kotlin.ch08

import java.io.*
import java.util.*

class AllPermutationPrinter(val n: Int, val m: Int) {
    private val permutation = IntArray(m) { 0 }

    fun dfs(depth: Int) {
        if(depth == m) {
            val sb = StringBuilder()
            permutation.forEach {
                sb.append("$it ")
            }
            println(sb)
        } else {
            for (i in 1 .. n) {
                permutation[depth] = i
                dfs(depth + 1)
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val printer = AllPermutationPrinter(n, m)
    printer.dfs(0)
}