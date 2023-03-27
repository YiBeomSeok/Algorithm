package inflearn.kotlin.ch10

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val input = Array(n) { IntArray(3) }
    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        input[i][0] = st.nextToken().toInt()
        input[i][1] = st.nextToken().toInt()
        input[i][2] = st.nextToken().toInt()
    }

    val blocks = Array<Block>(n) {
        Block(input[it][0], input[it][1], input[it][2])
    }
    blocks.sort()

    val dp = IntArray(n)
    dp[0] = blocks[0].height
    var answer = dp[0]

    for(i in 1 until n) {
        var max = 0
        for(j in i - 1 downTo 0) {
            if(blocks[j].weight > blocks[i].weight) {
                max = maxOf(max, dp[j])
            }
        }
        dp[i] = blocks[i].height + max
        answer = maxOf(answer, dp[i])
    }

    println(answer)
}

class Block(val size: Int, val height: Int, val weight: Int): Comparable<Block> {
    override fun compareTo(other: Block): Int {
        return other.size - this.size
    }
}