package inflearn2.kotlin.ch02.p6

import java.util.*

class Solution {
    fun solution(reports: Array<String>, times: String): Array<String> {
        return arrayOf()
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    "john 15:23",
                    "daniel 09:30",
                    "tom 07:23",
                    "park 09:59",
                    "luis 08:57"
                ), "08:33 09:45"
            )
        )
    )
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    "ami 12:56",
                    "daniel 15:00",
                    "bob 19:59",
                    "luis 08:57",
                    "bill 17:35",
                    "tom 07:23",
                    "john 15:23",
                    "park 09:59"
                ), "15:01 19:59"
            )
        )
    )
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    "cody 14:20",
                    "luis 10:12",
                    "alice 15:40",
                    "tom 15:20",
                    "daniel 14:50"
                ), "14:20 15:20"
            )
        )
    )
}