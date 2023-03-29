package inflearn2.kotlin.ch01.p8

import java.util.*

class Solution {
    fun solution(enter: IntArray?, exit: IntArray?): IntArray {
        return intArrayOf()
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(Arrays.toString(T.solution(intArrayOf(1, 2, 3, 4), intArrayOf(2, 4, 1, 3))))
    println(Arrays.toString(T.solution(intArrayOf(1, 2, 5, 3, 4), intArrayOf(2, 3, 1, 4, 5))))
    println(Arrays.toString(T.solution(intArrayOf(1, 3, 2, 4, 5, 7, 6, 8), intArrayOf(2, 3, 5, 6, 1, 4, 8, 7))))
    println(Arrays.toString(T.solution(intArrayOf(1, 4, 7, 2, 3, 5, 6), intArrayOf(5, 2, 6, 1, 7, 3, 4))))
    println(Arrays.toString(T.solution(intArrayOf(1, 4, 2, 3), intArrayOf(2, 1, 4, 3))))
}