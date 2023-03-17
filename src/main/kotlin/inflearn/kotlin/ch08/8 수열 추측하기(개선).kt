package inflearn.kotlin.ch08

import java.util.*
import java.io.BufferedReader
import java.io.InputStreamReader

class Solution9(val pyramidSize: Int, val targetValue: Int) {
    private val combinationValues = Array(35) { IntArray(35) { 0 } }
    private val pyramidWeights = IntArray(pyramidSize) { 0 }
    private val permutation = IntArray(pyramidSize) { 0 }
    private val visited = IntArray(pyramidSize + 1) { 0 }

    private var found = false

    init {
        for (i in 0 until pyramidSize) {
            pyramidWeights[i] = getCombinationValue(pyramidSize - 1, i)
        }
        dfs(0, 0)
    }

    // Calculate the combination value for nCr
    private fun getCombinationValue(n: Int, r: Int): Int {
        if (combinationValues[n][r] > 0) return combinationValues[n][r]

        if (n == r || r == 0) return 1
        else {
            combinationValues[n][r] = getCombinationValue(n - 1, r - 1) + getCombinationValue(n - 1, r)
            return combinationValues[n][r]
        }
    }

    // DFS to generate permutations and calculate the target value
    private fun dfs(depth: Int, sum: Int) {
        if (found) return
        if (depth == pyramidSize) {
            if (sum == targetValue) {
                for (x in permutation) print("$x ")
                found = true
            }
        } else {
            for (i in 1..pyramidSize) {
                if (visited[i] == 0) {
                    visited[i] = 1
                    permutation[depth] = i
                    dfs(depth + 1, sum + (permutation[depth] * pyramidWeights[depth]))
                    visited[i] = 0
                }
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val pyramidSize = st.nextToken().toInt()
    val targetValue = st.nextToken().toInt()

    Solution9(pyramidSize, targetValue)
}