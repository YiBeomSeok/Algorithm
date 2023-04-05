package inflearn2.kotlin.ch02.p4

class Solution {
    fun solution(nums: IntArray, m: Int): Int {
        var answer = 0

        val sums = HashMap<Int, Int>()
        sums[0] = 1

        var sum = 0
        nums.forEach {
            sum += it
            with(sums.getOrDefault(sum, 0)) {
                answer += this
                sums[sum] = this + 1
            }
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