package inflearn2.kotlin.ch06.p2

class Solution {
    fun solution(fight: Array<IntArray>): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(arrayOf(intArrayOf(1, 3), intArrayOf(5, 7), intArrayOf(4, 2))))
    println(T.solution(arrayOf(intArrayOf(3, 2), intArrayOf(3, 5), intArrayOf(5, 2), intArrayOf(7, 3))))
    println(T.solution(arrayOf(intArrayOf(1, 2), intArrayOf(1, 5), intArrayOf(1, 7), intArrayOf(1, 3))))
    println(T.solution(arrayOf(intArrayOf(1, 7))))
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(5, 6),
                intArrayOf(6, 7)
            )
        )
    )
}