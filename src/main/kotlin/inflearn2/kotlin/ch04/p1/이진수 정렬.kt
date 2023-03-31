package inflearn2.kotlin.ch04.p1

import java.util.*

class Solution {
    fun solution(nums: IntArray): IntArray {

        val res = Array(nums.size) { IntArray(2) }

        for(i in nums.indices) {
            res[i][0] = nums[i]
            res[i][1] = nums[i].countOneBits()
        }

        res.sortWith(
            compareBy<IntArray> {
                it[1]
            }.thenBy {
                it[0]
            }
        )

        val answer = IntArray(nums.size)
        for(i in answer.indices) {
            answer[i] = res[i][0]
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(Arrays.toString(T.solution(intArrayOf(5, 6, 7, 8, 9))))
    println(Arrays.toString(T.solution(intArrayOf(5, 4, 3, 2, 1))))
    println(Arrays.toString(T.solution(intArrayOf(12, 5, 7, 23, 45, 21, 17))))
}