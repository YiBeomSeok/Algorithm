package inflearn.kotlin.ch08

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class DogTruck(val size: Int, val maximum: Int, val dogsWeights: IntArray) {

    var sum = 0

    fun getSumMax(): Int {
        dfs(0, 0)
        return sum
    }

    private fun dfs(curSum: Int, depth: Int) {
        if(curSum > maximum) return

        if(depth == size) {
            sum = sum.coerceAtLeast(curSum)
        } else {
            dfs(curSum + dogsWeights[depth], depth + 1)
            dfs(curSum, depth + 1)
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val c = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val weights = IntArray(n)
    for(i in 0 until n) {
        weights[i] = br.readLine().toInt()
    }

    val truck = DogTruck(n, c, weights)
    println(truck.getSumMax())
}