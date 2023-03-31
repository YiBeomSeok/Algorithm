package inflearn2.kotlin.ch05.p5

import java.util.*

class Solution {
    fun solution(students: Array<String>): IntArray {
        val n = students.size
        return IntArray(n)
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(Arrays.toString(T.solution(arrayOf("a 20", "b 12", "a 10", "c 11", "e 12"))))
    println(Arrays.toString(T.solution(arrayOf("a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"))))
    println(Arrays.toString(T.solution(arrayOf("b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"))))
    println(Arrays.toString(T.solution(arrayOf("a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"))))
}