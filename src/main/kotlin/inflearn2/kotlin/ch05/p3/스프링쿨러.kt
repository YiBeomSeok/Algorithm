package inflearn2.kotlin.ch05.p3

import java.util.*

class Solution {
    fun solution(n: Int, nums: IntArray): Int {

        val sprinklers = Array(n) {
            val left = if (it - nums[it] < 0) 0 else it - nums[it]
            val right = if (it + nums[it] > n) n else it + nums[it]
            intArrayOf(left, right)
        }.apply {
            sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        }

        var count = 0
        var start = 0
        var end = 0
        var index = 0
        while(index < sprinklers.size){
            while(index < sprinklers.size && sprinklers[index][0] <= start) {
                end = maxOf(end, sprinklers[index][1])
                index++
            }
            count++

            if(end == n) return count
            if(start == end) return -1
            start = end
        }

        return count
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(8, intArrayOf(1, 1, 1, 2, 1, 1, 2, 1, 1)))
    println(T.solution(4, intArrayOf(1, 2, 2, 0, 0)))
    println(T.solution(5, intArrayOf(2, 0, 0, 0, 0, 2)))
    println(T.solution(11, intArrayOf(1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1)))
}