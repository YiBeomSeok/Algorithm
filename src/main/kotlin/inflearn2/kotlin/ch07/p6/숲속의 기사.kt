package inflearn2.kotlin.ch07.p6

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
                intArrayOf(4, 1, 0, 0, 0, 0, 1, 0),
                intArrayOf(0, 0, 0, 1, 0, 1, 0, 0),
                intArrayOf(0, 2, 1, 1, 3, 0, 4, 0),
                intArrayOf(0, 0, 0, 4, 1, 1, 1, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(3, 0, 0, 0, 1, 4, 4, 4),
                intArrayOf(0, 1, 1, 0, 0, 0, 1, 0),
                intArrayOf(0, 1, 4, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 0, 0, 0, 0),
                intArrayOf(1, 0, 1, 0, 0, 1, 1, 0),
                intArrayOf(4, 0, 0, 0, 1, 0, 0, 0),
                intArrayOf(4, 1, 0, 0, 1, 0, 0, 0),
                intArrayOf(4, 0, 0, 0, 0, 0, 1, 2)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(4, 1, 0, 1, 0),
                intArrayOf(0, 1, 0, 1, 0),
                intArrayOf(0, 0, 2, 3, 4),
                intArrayOf(0, 1, 0, 1, 0)
            )
        )
    )
}