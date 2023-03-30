package inflearn2.kotlin.ch03.p1

import java.util.*

class Solution {
    fun solution(nums: IntArray): Int {
        val sortedSet = TreeSet<Int>()
        nums.forEach { sortedSet.add(it) }

        var prev = sortedSet.first()
        var count = 1
        var answer = 1
        sortedSet.remove(prev)
        sortedSet.forEach {
            if(prev + 1 == it) {
                count++
                prev = it
                answer = maxOf(answer, count)
            }
            else count = 1
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(intArrayOf(8, 1, 9, 3, 10, 2, 4, 0, 2, 3)))
    println(T.solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0)))
    println(T.solution(intArrayOf(3, 3, 3, 3, 3, 3, 3, 3)))
    println(T.solution(intArrayOf(-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1)))
    println(T.solution(intArrayOf(-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7)))
}