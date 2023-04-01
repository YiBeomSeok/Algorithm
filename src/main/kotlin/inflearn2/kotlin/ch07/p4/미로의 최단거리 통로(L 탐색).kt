package inflearn2.kotlin.ch07.p4

class Solution {
    fun solution(board: Array<IntArray>): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    val arr = arrayOf(
        intArrayOf(0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 1, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 1, 0, 0, 0),
        intArrayOf(1, 1, 0, 1, 0, 1, 1),
        intArrayOf(1, 1, 0, 1, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 1, 0, 0),
        intArrayOf(1, 0, 1, 0, 0, 0, 0)
    )
    println(T.solution(arr))
}