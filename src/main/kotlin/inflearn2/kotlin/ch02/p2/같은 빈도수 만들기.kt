package inflearn2.kotlin.ch02.p2

import java.util.*

class Solution {
    fun solution(s: String): IntArray {
        val hashMap = HashMap<Char, Int>()

        var max = 0
        s.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
            max = maxOf(hashMap.getOrDefault(it, 0), max)
        }

        val answer = IntArray(5)
        for(i in 0 until 5) {
            answer[i] = max - hashMap.getOrDefault('a' + i, 0)
        }

        return answer
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