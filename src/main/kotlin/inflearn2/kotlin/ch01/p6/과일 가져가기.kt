class Solution {
    fun solution(fruit: Array<IntArray>?): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(10, 20, 30),
                intArrayOf(12, 15, 20),
                intArrayOf(20, 12, 15),
                intArrayOf(15, 20, 10),
                intArrayOf(10, 15, 10)
            )
        )
    )
    println(T.solution(arrayOf(intArrayOf(10, 9, 11), intArrayOf(15, 20, 25))))
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 3, 27),
                intArrayOf(20, 5, 5),
                intArrayOf(19, 5, 6),
                intArrayOf(10, 10, 10),
                intArrayOf(15, 10, 5),
                intArrayOf(3, 7, 20)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(3, 7, 20),
                intArrayOf(10, 15, 5),
                intArrayOf(19, 5, 6),
                intArrayOf(10, 10, 10),
                intArrayOf(15, 10, 5),
                intArrayOf(3, 7, 20),
                intArrayOf(12, 12, 6),
                intArrayOf(10, 20, 0),
                intArrayOf(5, 10, 15)
            )
        )
    )
}