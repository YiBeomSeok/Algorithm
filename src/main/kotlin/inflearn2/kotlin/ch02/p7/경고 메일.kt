package inflearn2.kotlin.ch02.p7

import java.util.*

class Solution {
    fun solution(reports: Array<String>, time: Int): Array<String> {
        return arrayOf()
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    "john 09:30 in",
                    "daniel 10:05 in",
                    "john 10:15 out",
                    "luis 11:57 in",
                    "john 12:03 in",
                    "john 12:20 out",
                    "luis 12:35 out",
                    "daniel 15:05 out"
                ), 60
            )
        )
    )
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    "bill 09:30 in",
                    "daniel 10:00 in",
                    "bill 11:15 out",
                    "luis 11:57 in",
                    "john 12:03 in",
                    "john 12:20 out",
                    "luis 14:35 out",
                    "daniel 14:55 out"
                ), 120
            )
        )
    )
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    "cody 09:14 in",
                    "bill 09:25 in",
                    "luis 09:40 in",
                    "bill 10:30 out",
                    "cody 10:35 out",
                    "luis 10:35 out",
                    "bill 11:15 in",
                    "bill 11:22 out",
                    "luis 15:30 in",
                    "luis 15:33 out"
                ), 70
            )
        )
    )
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    "chato 09:15 in",
                    "emilly 10:00 in",
                    "chato 10:15 out",
                    "luis 10:57 in",
                    "daniel 12:00 in",
                    "emilly 12:20 out",
                    "luis 11:20 out",
                    "daniel 15:05 out"
                ), 60
            )
        )
    )
}
