package inflearn2.kotlin.ch05.p6

class Solution {
    fun solution(n: Int, trans: Array<IntArray>, bookings: Array<IntArray>): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            5,
            arrayOf(intArrayOf(1, 4, 2), intArrayOf(2, 5, 1)),
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 5),
                intArrayOf(2, 3),
                intArrayOf(2, 4),
                intArrayOf(2, 5),
                intArrayOf(2, 5),
                intArrayOf(3, 5),
                intArrayOf(3, 4)
            )
        )
    )
    println(
        T.solution(
            5,
            arrayOf(intArrayOf(2, 3, 1), intArrayOf(1, 5, 1)),
            arrayOf(
                intArrayOf(2, 5),
                intArrayOf(1, 5),
                intArrayOf(1, 3),
                intArrayOf(2, 4),
                intArrayOf(2, 5),
                intArrayOf(2, 3)
            )
        )
    )
    println(
        T.solution(
            8,
            arrayOf(intArrayOf(1, 8, 3), intArrayOf(3, 8, 1)),
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(5, 8),
                intArrayOf(2, 7),
                intArrayOf(3, 8),
                intArrayOf(2, 7),
                intArrayOf(2, 8),
                intArrayOf(3, 8),
                intArrayOf(6, 8),
                intArrayOf(7, 8),
                intArrayOf(5, 8),
                intArrayOf(2, 5),
                intArrayOf(2, 7),
                intArrayOf(3, 7),
                intArrayOf(3, 8)
            )
        )
    )
    println(
        T.solution(
            9, arrayOf(intArrayOf(1, 8, 3), intArrayOf(3, 9, 2), intArrayOf(1, 5, 3)), arrayOf(
                intArrayOf(1, 9),
                intArrayOf(5, 8),
                intArrayOf(2, 9),
                intArrayOf(3, 8),
                intArrayOf(2, 9),
                intArrayOf(1, 9),
                intArrayOf(8, 9),
                intArrayOf(3, 9),
                intArrayOf(1, 8),
                intArrayOf(6, 8),
                intArrayOf(7, 8),
                intArrayOf(5, 8),
                intArrayOf(3, 5),
                intArrayOf(3, 7),
                intArrayOf(4, 7),
                intArrayOf(5, 8)
            )
        )
    )
    println(
        T.solution(
            9, arrayOf(intArrayOf(2, 7, 2), intArrayOf(3, 9, 2), intArrayOf(1, 5, 3)), arrayOf(
                intArrayOf(1, 9),
                intArrayOf(4, 8),
                intArrayOf(2, 9),
                intArrayOf(5, 9),
                intArrayOf(3, 8),
                intArrayOf(2, 9),
                intArrayOf(1, 9),
                intArrayOf(8, 9),
                intArrayOf(3, 9),
                intArrayOf(1, 8),
                intArrayOf(6, 8),
                intArrayOf(3, 6),
                intArrayOf(7, 8),
                intArrayOf(5, 8),
                intArrayOf(3, 5),
                intArrayOf(2, 7),
                intArrayOf(1, 7),
                intArrayOf(2, 8)
            )
        )
    )
}