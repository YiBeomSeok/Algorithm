package inflearn2.kotlin.ch04.p3

import java.util.*
import kotlin.math.*

class Solution {
    fun solution(nums: IntArray, k: Int): Int {
        var answer = 0
        val diff = IntArray(nums.size / 2)
        nums.sortDescending()

        for(i in nums.indices step(2)) {
            diff[i / 2] = nums[i] - nums[i + 1]

            answer += nums[i + 1]
        }

        diff.sortDescending()
        for(i in 0 until k) {
            answer += diff[i]
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(intArrayOf(7, 8, 5, 12, 3, 1, 3, 1, 1, 12), 2))
    println(T.solution(intArrayOf(8, 2, 12, 12, 12, 12, 2, 2), 2))
    println(T.solution(intArrayOf(3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7), 3))
    println(T.solution(intArrayOf(12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12), 3))
    println(T.solution(intArrayOf(14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19), 3))
}