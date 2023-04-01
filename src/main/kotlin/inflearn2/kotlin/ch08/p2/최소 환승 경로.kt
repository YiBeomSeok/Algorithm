package inflearn2.kotlin.ch08.p2

class Solution {
    fun solution(routes: Array<IntArray>, s: Int, e: Int): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 2, 3, 4, 5, 6, 19),
                intArrayOf(2, 7, 8, 13),
                intArrayOf(5, 9, 10),
                intArrayOf(9, 11, 12, 18),
                intArrayOf(13, 14, 15),
                intArrayOf(14, 12, 16, 17)
            ), 1, 12
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(9, 3, 12),
                intArrayOf(6, 5, 8),
                intArrayOf(2, 8, 14, 15),
                intArrayOf(2, 14, 16)
            ), 1, 14
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(7, 12),
                intArrayOf(5, 19),
                intArrayOf(7, 19),
                intArrayOf(9, 12, 13),
                intArrayOf(9, 5, 15)
            ), 9, 19
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(9, 7, 10),
                intArrayOf(7, 6, 3, 8),
                intArrayOf(5, 11, 8, 12)
            ), 1, 10
        )
    )
}