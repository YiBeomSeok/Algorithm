package inflearn2.kotlin.ch05.p2

class Solution {
    fun solution(nums: IntArray): Int {
        nums.sort()
        var left = 0
        var right = nums.size - 1
        var count = 0
        while(left <= right) {
            if(nums[left] + nums[right] <= 5) {
                left++
            }
            count++

            right--
        }
        return count
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(intArrayOf(2, 5, 3, 4, 2, 3)))
    println(T.solution(intArrayOf(2, 3, 4, 5)))
    println(T.solution(intArrayOf(3, 3, 3, 3, 3)))
}