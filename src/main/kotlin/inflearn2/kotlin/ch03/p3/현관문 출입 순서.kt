package inflearn2.kotlin.ch03.p3

import java.util.*

class Solution {
    fun solution(arrival: IntArray, state: IntArray): IntArray {
        return intArrayOf()
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(Arrays.toString(T.solution(intArrayOf(0, 1, 1, 1, 2, 3, 8, 8), intArrayOf(1, 0, 0, 1, 0, 0, 1, 0))))
    println(Arrays.toString(T.solution(intArrayOf(3, 3, 4, 5, 5, 5), intArrayOf(1, 0, 1, 0, 1, 0))))
    println(
        Arrays.toString(
            T.solution(
                intArrayOf(2, 2, 2, 3, 4, 8, 8, 9, 10, 10),
                intArrayOf(1, 0, 0, 0, 1, 1, 0, 1, 1, 0)
            )
        )
    )
}