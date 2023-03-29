package inflearn2.kotlin.ch02.p3

class Solution {
    fun solution(s: String): Int {
        val hashMap = HashMap<Char, Int>()

        s.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }
        
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution("aaabbbcc"))
    println(T.solution("aaabbc"))
    println(T.solution("aebbbbc"))
    println(T.solution("aaabbbcccde"))
    println(T.solution("aaabbbcccdddeeeeeff"))
}