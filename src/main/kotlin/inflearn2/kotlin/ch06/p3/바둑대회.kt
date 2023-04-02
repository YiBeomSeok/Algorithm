package inflearn2.kotlin.ch06.p3

import kotlin.math.*

class Solution {

    lateinit var cans: Array<IntArray>
    var answer = 0
    var n = 0

    fun solution(cans: Array<IntArray>): Int {
        var wSum = 0
        var bSum = 0

        cans.forEach {
            bSum += it[1]
        }

        init(cans)

        dfs(0, wSum, bSum, 0)

        return answer
    }

    private fun init(cans: Array<IntArray>) {
        this.cans = cans
        answer = Int.MAX_VALUE
        n = cans.size
    }

    private fun dfs(curIndex: Int, wSum: Int, bSum: Int, depth: Int) {
        if(depth == n / 2) {
            answer = minOf(abs(wSum - bSum), answer)
        } else {
            for(i in curIndex  until n) {
                dfs(i + 1, wSum + cans[i][0], bSum - cans[i][1], depth + 1)
            }
        }
    }
}
fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(87, 84),
                intArrayOf(66, 78),
                intArrayOf(94, 94),
                intArrayOf(93, 87),
                intArrayOf(72, 92),
                intArrayOf(78, 63)
            )
        )
    )
    println(T.solution(arrayOf(intArrayOf(10, 20), intArrayOf(15, 25), intArrayOf(35, 23), intArrayOf(55, 20))))
    println(
        T.solution(
            arrayOf(
                intArrayOf(11, 27),
                intArrayOf(16, 21),
                intArrayOf(35, 21),
                intArrayOf(52, 21),
                intArrayOf(25, 33),
                intArrayOf(25, 32),
                intArrayOf(37, 59),
                intArrayOf(33, 47)
            )
        )
    )
}