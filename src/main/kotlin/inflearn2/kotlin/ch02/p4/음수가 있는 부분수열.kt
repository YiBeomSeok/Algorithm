package inflearn2.kotlin.ch02.p4

class Solution {
    fun solution(nums: IntArray, m: Int): Int {
        var answer = 0

        val hashMap = HashMap<Int, Int>()
        hashMap[0] = 1
        var sum = 0

        for(i in nums.indices) {
            sum += nums[i]

            answer += hashMap.getOrDefault(sum - m, 0)
            hashMap[sum] = hashMap.getOrDefault(sum, 0) + 1
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(intArrayOf(2, 2, 3, -1, -1, -1, 3, 1, 1), 5))
    println(T.solution(intArrayOf(1, 2, 3, -3, 1, 2, 2, -3), 5))
    println(T.solution(intArrayOf(1, 2, 3, -3, 1, 2), 3))
    println(T.solution(intArrayOf(-1, 0, 1), 0))
    println(T.solution(intArrayOf(-1, -1, -1, 1), 0))
}