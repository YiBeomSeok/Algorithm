package inflearn2.kotlin.ch01

import java.util.Arrays

class Solution {
    fun solution(n: Int, ladder: Array<IntArray>): CharArray {
        val answer = CharArray(n) { ' ' }
        for(i in 0 until n) {
            answer[i] = 'A' + i
        }

        for(line in ladder) {
            for(x in line) {
                val tmp = answer[x]
                answer[x] = answer[x - 1]
                answer[x - 1] = tmp
            }
        }
        return answer
    }
}

fun main() {
    val t = Solution()
    println(t.solution(5, arrayOf(intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(1, 4))).contentToString())
    println(t.solution(7, arrayOf(intArrayOf(1, 3, 5), intArrayOf(1, 3, 6), intArrayOf(2, 4))).contentToString())
    println(
        t.solution(
            8,
            arrayOf(intArrayOf(1, 5), intArrayOf(2, 4, 7), intArrayOf(1, 5, 7), intArrayOf(2, 5, 7))
        ).contentToString()
    )
    println(
        t.solution(
            12,
            arrayOf(
                intArrayOf(1, 5, 8, 10),
                intArrayOf(2, 4, 7),
                intArrayOf(1, 5, 7, 9, 11),
                intArrayOf(2, 5, 7, 10),
                intArrayOf(3, 6, 8, 11)
            )
        ).contentToString()
    )
}
