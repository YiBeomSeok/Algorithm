package inflearn.kotlin.ch08

import java.io.*
import java.util.*

class SubsetFinder(val n: Int, val intArray: IntArray) {

    var answer = false

    fun hasEqualSumOfSubset(): Boolean {
        val sum1 = intArray.sum()
        val sum2 = 0
        val depth = 0
        dfs(sum1, sum2, depth)
        return answer
    }

    // return 조건 중요!
    private fun dfs(sum1: Int, sum2: Int, depth: Int) {
        if (answer) return
        if (sum1 < sum2) return

        if (depth == n) {
            if (sum1 == sum2) {
                answer = true
            }
        } else {
            val cur = intArray[depth]

            dfs(sum1 - cur, sum2 + cur, depth + 1)
            dfs(sum1, sum2, depth + 1)
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val intArray = IntArray(n)
    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        intArray[i] = st.nextToken().toInt()
    }

    val finder = SubsetFinder(n, intArray)
    if (finder.hasEqualSumOfSubset()) {
        println("YES")
    } else {
        println("NO")
    }
}