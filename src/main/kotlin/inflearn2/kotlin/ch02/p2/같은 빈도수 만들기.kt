package inflearn2.kotlin.ch02.p2

import java.util.*

class Solution {
    fun solution(s: String): IntArray {
        return IntArray(5)
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(Arrays.toString(T.solution("aaabc")))
    println(Arrays.toString(T.solution("aabb")))
    println(Arrays.toString(T.solution("abcde")))
    println(Arrays.toString(T.solution("abcdeabc")))
    println(Arrays.toString(T.solution("abbccddee")))
}