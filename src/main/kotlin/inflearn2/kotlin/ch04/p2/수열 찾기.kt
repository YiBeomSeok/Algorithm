package inflearn2.kotlin.ch04.p2

import java.util.*

class Solution {
    fun solution(nums: IntArray): IntArray {
        val answer = IntArray(nums.size / 2)

        val nH = HashMap<Int, Int>()
        for(x in nums) {
            nH[x] = nH.getOrDefault(x, 0) + 1
        }

        nums.sort()

        var index = 0
        for(x in nums) {
            if(nH[x] == 0) continue

            answer[index] = x
            index++

            nH[x] = nH[x]!! - 1
            nH[x * 2] = nH[x * 2]!! - 1
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(Arrays.toString(T.solution(intArrayOf(1, 10, 2, 3, 5, 6))))
    println(Arrays.toString(T.solution(intArrayOf(1, 1, 6, 2, 2, 7, 3, 14))))
    println(Arrays.toString(T.solution(intArrayOf(14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14))))
}