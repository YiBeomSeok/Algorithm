package inflearn2.kotlin.ch08.p4

class Solution {
    fun solution(board: Array<IntArray>): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(arrayOf(intArrayOf(3, 1, 3), intArrayOf(1, 4, 2), intArrayOf(4, 2, 3))))
    println(
        T.solution(
            arrayOf(
                intArrayOf(3, 2, 1, 3),
                intArrayOf(1, 1, 4, 2),
                intArrayOf(3, 4, 2, 1),
                intArrayOf(1, 2, 2, 4)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(3, 2, 1, 3, 1, 2),
                intArrayOf(2, 1, 1, 1, 4, 2),
                intArrayOf(2, 2, 2, 1, 2, 2),
                intArrayOf(1, 3, 3, 4, 4, 4),
                intArrayOf(1, 2, 2, 3, 3, 4)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(3, 2, 1, 3, 1, 2, 2, 2),
                intArrayOf(2, 1, 1, 1, 4, 2, 1, 1),
                intArrayOf(2, 2, 2, 1, 2, 2, 3, 4),
                intArrayOf(1, 3, 3, 4, 4, 4, 3, 1),
                intArrayOf(1, 2, 2, 3, 3, 4, 3, 4),
                intArrayOf(1, 2, 2, 3, 3, 1, 1, 1)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 2, 3, 2, 1, 3, 1, 2, 2, 2),
                intArrayOf(1, 2, 2, 1, 1, 1, 4, 2, 1, 1),
                intArrayOf(3, 2, 2, 2, 2, 1, 2, 2, 3, 4),
                intArrayOf(3, 3, 1, 3, 3, 4, 4, 4, 3, 1),
                intArrayOf(1, 1, 1, 2, 2, 3, 3, 4, 3, 4),
                intArrayOf(1, 1, 1, 2, 2, 3, 3, 1, 1, 1)
            )
        )
    )
}