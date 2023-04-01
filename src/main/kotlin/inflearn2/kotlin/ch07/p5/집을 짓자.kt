package inflearn2.kotlin.ch07.p5

class Solution {
    fun solution(board: Array<IntArray>): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 0, 2, 0, 1),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 2, 1, 0, 0),
                intArrayOf(2, 0, 0, 2, 2),
                intArrayOf(0, 0, 0, 0, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 0, 0, 1),
                intArrayOf(0, 0, 2, 0),
                intArrayOf(0, 0, 1, 0),
                intArrayOf(2, 2, 0, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 2, 0, 0),
                intArrayOf(0, 0, 1, 2),
                intArrayOf(0, 2, 0, 0),
                intArrayOf(0, 2, 1, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 0, 0, 1),
                intArrayOf(0, 0, 2, 0),
                intArrayOf(0, 0, 1, 0),
                intArrayOf(2, 2, 0, 1)
            )
        )
    )
}