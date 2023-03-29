package inflearn2.kotlin.ch02.p5

class Solution {
    fun solution(votes: Array<String>, k: Int): String {
        return " "
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf("john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"),
            2
        )
    )
    println(
        T.solution(
            arrayOf(
                "john tom",
                "park luis",
                "john luis",
                "luis tom",
                "park tom",
                "luis john",
                "luis park",
                "park john",
                "john park",
                "tom john",
                "tom park",
                "tom luis"
            ), 2
        )
    )
    println(
        T.solution(
            arrayOf(
                "cody tom",
                "john tom",
                "cody luis",
                "daniel luis",
                "john luis",
                "luis tom",
                "daniel tom",
                "luis john"
            ), 2
        )
    )
    println(
        T.solution(
            arrayOf(
                "bob tom",
                "bob park",
                "park bob",
                "luis park",
                "daniel luis",
                "luis bob",
                "park luis",
                "tom bob",
                "tom luis",
                "john park",
                "park john"
            ), 3
        )
    )
}