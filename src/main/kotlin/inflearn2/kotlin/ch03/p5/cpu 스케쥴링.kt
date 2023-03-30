package inflearn2.kotlin.ch03.p5

import java.util.*

internal class Solution {
    fun solution(tasks: Array<IntArray>): IntArray {
        return intArrayOf()
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    intArrayOf(2, 3),
                    intArrayOf(1, 2),
                    intArrayOf(8, 2),
                    intArrayOf(3, 1),
                    intArrayOf(10, 2)
                )
            )
        )
    )
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    intArrayOf(5, 2),
                    intArrayOf(7, 3),
                    intArrayOf(1, 3),
                    intArrayOf(1, 5),
                    intArrayOf(2, 2),
                    intArrayOf(1, 1)
                )
            )
        )
    )
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(1, 3),
                    intArrayOf(3, 3),
                    intArrayOf(8, 2),
                    intArrayOf(1, 5),
                    intArrayOf(2, 2),
                    intArrayOf(1, 1)
                )
            )
        )
    )
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    intArrayOf(999, 1000),
                    intArrayOf(996, 1000),
                    intArrayOf(998, 1000),
                    intArrayOf(999, 7)
                )
            )
        )
    )
}