package inflearn2.kotlin.ch01.p7


internal class Solution {
    fun solution(keypad: IntArray?, password: String?): Int {
        return 0
    }


}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(intArrayOf(2, 5, 3, 7, 1, 6, 4, 9, 8), "7596218"))
    println(T.solution(intArrayOf(1, 5, 7, 3, 2, 8, 9, 4, 6), "63855526592"))
    println(T.solution(intArrayOf(2, 9, 3, 7, 8, 6, 4, 5, 1), "323254677"))
    println(T.solution(intArrayOf(1, 6, 7, 3, 8, 9, 4, 5, 2), "3337772122"))
}