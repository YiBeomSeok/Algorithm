package inflearn2.kotlin.ch06.p6

class Solution {
    var answer = 0

    fun solution(s: String): Int {

        init()

        dfs(0, s)

        return answer
    }

    private fun init() {
        answer = 0
    }

    private fun dfs(start: Int, s: String) {
        if(start == s.length) {
            answer++
        } else {
            for(i in start .. start + 1) {
                if(i == s.length) return

                val curNumber = s.substring(start, i + 1).toInt()
                if(curNumber == 0 || curNumber > 26) return

                dfs(i + 1, s)
            }
        }
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution("25114"))
    println(T.solution("23251232"))
    println(T.solution("21020132"))
    println(T.solution("21350"))
    println(T.solution("120225"))
    println(T.solution("232012521"))
}