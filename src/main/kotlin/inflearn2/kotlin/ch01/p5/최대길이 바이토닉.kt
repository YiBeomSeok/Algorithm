package inflearn2.kotlin.ch01.p5

class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0

        val peaks = mutableListOf<Int>()

        for(i in 1 until nums.size - 1) {
            if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) peaks.add(i)
        }

        peaks.forEach {
            var curCnt = 1
            for(i in it downTo 1) {
                if(nums[i] > nums[i - 1]) curCnt++
                else break
            }
            for (i in it until nums.size - 1) {
                if(nums[i] > nums[i + 1]) curCnt++
                else break
            }
            answer = maxOf(answer, curCnt)
        }

        return answer
    }
}

fun main() {
    val T = Solution()
    println(T.solution(intArrayOf(1, 2, 1, 2, 3, 2, 1)))
    println(T.solution(intArrayOf(1, 1, 2, 3, 5, 7, 4, 3, 1, 2)))
    println(T.solution(intArrayOf(3, 2, 1, 3, 2, 4, 6, 7, 3, 1)))
    println(T.solution(intArrayOf(1, 3, 1, 2, 1, 5, 3, 2, 1, 1)))
}