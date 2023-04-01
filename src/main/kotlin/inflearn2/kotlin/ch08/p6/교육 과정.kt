package inflearn2.kotlin.ch08.p6

class Solution {
    fun solution(
        subjects: Array<String>,
        course: Array<String>
    ): Array<String> {
        return arrayOf()
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf("english", "math", "physics", "art", "music"),
            arrayOf("art math", "physics art", "art music", "physics math", "english physics")
        )
    )
//    println(
//        T.solution(
//            arrayOf("art", "economics", "history", "chemistry"),
//            arrayOf("chemistry history", "economics history", "art economics")
//        )[0]
//    )
//    println(
//        T.solution(
//            arrayOf("math", "science", "music", "biology"),
//            arrayOf("science music", "math music", "math science", "biology math")
//        )
//    )
}