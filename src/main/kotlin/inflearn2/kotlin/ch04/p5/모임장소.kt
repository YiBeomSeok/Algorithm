package inflearn2.kotlin.ch04.p5

import kotlin.math.*

class Solution {
    fun solution(board: Array<IntArray>): Int {
        var answer = 0
        val n = board.size

        val row = mutableListOf<Int>()
        val col = mutableListOf<Int>()

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (board[i][j] == 1) {
                    row.add(i)
                    col.add(j)
                }
            }
        }
        col.sort()

        val x = row[row.size / 2]
        val y = col[col.size / 2]

        for (p in row) answer += abs(x - p)
        for (p in col) answer += abs(y - p)

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 0, 0, 0, 1),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 0, 0, 0, 1, 1),
                intArrayOf(0, 1, 0, 0, 1, 0),
                intArrayOf(0, 1, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0),
                intArrayOf(0, 0, 0, 0, 0, 1),
                intArrayOf(1, 0, 0, 0, 1, 1)
            )
        )
    )
}