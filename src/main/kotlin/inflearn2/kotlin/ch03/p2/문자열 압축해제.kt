package inflearn2.kotlin.ch03.p2

class Solution {
    fun solution(s: String): String {
        return ""
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution("3(a2(b))ef"))
    println(T.solution("2(ab)k3(bc)"))
    println(T.solution("2(ab3((cd)))"))
    println(T.solution("2(2(ab)3(2(ac)))"))
    println(T.solution("3(ab2(sg))"))
}