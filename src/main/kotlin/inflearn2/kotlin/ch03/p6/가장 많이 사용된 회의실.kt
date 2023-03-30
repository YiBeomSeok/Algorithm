package inflearn2.kotlin.ch03.p6

internal class Solution {
    fun solution(n: Int, meetings: Array<IntArray>): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            2,
            arrayOf(intArrayOf(0, 5), intArrayOf(2, 7), intArrayOf(4, 5), intArrayOf(7, 10), intArrayOf(9, 12))
        )
    )
    println(
        T.solution(
            3,
            arrayOf(
                intArrayOf(3, 9),
                intArrayOf(1, 10),
                intArrayOf(5, 8),
                intArrayOf(10, 15),
                intArrayOf(9, 14),
                intArrayOf(12, 14),
                intArrayOf(15, 20)
            )
        )
    )
    println(
        T.solution(
            3,
            arrayOf(
                intArrayOf(1, 30),
                intArrayOf(2, 15),
                intArrayOf(3, 10),
                intArrayOf(4, 12),
                intArrayOf(6, 10)
            )
        )
    )
    println(
        T.solution(
            4,
            arrayOf(
                intArrayOf(3, 20),
                intArrayOf(1, 25),
                intArrayOf(5, 8),
                intArrayOf(10, 15),
                intArrayOf(9, 14),
                intArrayOf(12, 14),
                intArrayOf(15, 20)
            )
        )
    )
}