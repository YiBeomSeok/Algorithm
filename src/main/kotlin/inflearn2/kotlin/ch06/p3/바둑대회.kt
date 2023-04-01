package inflearn2.kotlin.ch06.p3

class Solution {
    fun solution(cans: Array<IntArray>): Int {
        return 0
    }
}
fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(87, 84),
                intArrayOf(66, 78),
                intArrayOf(94, 94),
                intArrayOf(93, 87),
                intArrayOf(72, 92),
                intArrayOf(78, 63)
            )
        )
    )
    println(T.solution(arrayOf(intArrayOf(10, 20), intArrayOf(15, 25), intArrayOf(35, 23), intArrayOf(55, 20))))
    println(
        T.solution(
            arrayOf(
                intArrayOf(11, 27),
                intArrayOf(16, 21),
                intArrayOf(35, 21),
                intArrayOf(52, 21),
                intArrayOf(25, 33),
                intArrayOf(25, 32),
                intArrayOf(37, 59),
                intArrayOf(33, 47)
            )
        )
    )
}