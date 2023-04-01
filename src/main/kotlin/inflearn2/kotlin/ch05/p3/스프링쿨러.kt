package inflearn2.kotlin.ch05.p3

import java.util.*

class Solution {
    fun solution(n: Int, nums: IntArray): Int {
        val pq = PriorityQueue<Int>(compareByDescending { it })
        nums.forEach {
            pq.offer(it)
        }

        var i = 0
        var count = 0
        while(i < n) {
            if(i + nums[i] >= n - 1) break
            val next = if(i + pq.peek() >= n) n - 1 else i + pq.peek()
            for(j in next downTo i) {
                if(j - nums[j] <= i) {
                    i = j
                    count++
                    pq.remove(nums[j])
                    break
                }
                if(j == i && nums[i] == 0) return -1
            }
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