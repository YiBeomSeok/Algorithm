package inflearn2.kotlin.ch05.p1

class Solution {
    fun solution(nums: IntArray, m: Int): Int {
        nums.sort()
        var left = 0
        var right = nums.size - 1
        var count = 0
        while(left <= right) {
            if(nums[left] + nums[right] <= m) {
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
    println(T.solution(intArrayOf(90, 50, 70, 100, 60), 140))
    println(T.solution(intArrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90), 100))
    println(
        T.solution(
            intArrayOf(
                68,
                72,
                30,
                105,
                55,
                115,
                36,
                67,
                119,
                111,
                95,
                24,
                25,
                80,
                55,
                85,
                75,
                83,
                21,
                81
            ), 120
        )
    )
}