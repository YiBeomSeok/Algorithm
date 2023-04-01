package inflearn2.kotlin.ch08.p5


internal class Solution {
    fun solution(board: Array<IntArray>, s: IntArray, e: IntArray): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0),
                intArrayOf(1, 0, 1, 1, 1, 0),
                intArrayOf(1, 0, 0, 0, 0, 0)
            ), intArrayOf(1, 0), intArrayOf(4, 5)
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0),
                intArrayOf(1, 0, 1, 1, 1, 0),
                intArrayOf(1, 0, 0, 0, 0, 0)
            ), intArrayOf(0, 0), intArrayOf(4, 2)
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 0, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 0),
                intArrayOf(1, 1, 0, 1, 1),
                intArrayOf(0, 0, 0, 0, 0)
            ), intArrayOf(0, 3), intArrayOf(4, 2)
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 1, 0, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0),
                intArrayOf(0, 1, 1, 0, 1, 1),
                intArrayOf(0, 0, 0, 0, 0, 0)
            ), intArrayOf(0, 0), intArrayOf(4, 5)
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 1, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 0, 0, 0, 0)
            ), intArrayOf(0, 0), intArrayOf(4, 3)
        )
    )
}