package inflearn2.kotlin.ch03.p4

class Solution {
    fun solution(laser: IntArray, enter: Array<String>): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            intArrayOf(30, 20, 25, 15),
            arrayOf("10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2")
        )
    )
    println(
        T.solution(
            intArrayOf(30, 20, 25, 15),
            arrayOf(
                "10:23 0",
                "10:40 3",
                "10:42 2",
                "10:52 3",
                "15:10 0",
                "15:20 3",
                "15:22 1",
                "15:23 0",
                "15:25 0"
            )
        )
    )
    println(
        T.solution(
            intArrayOf(30, 20, 25, 15),
            arrayOf("10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1")
        )
    )
}