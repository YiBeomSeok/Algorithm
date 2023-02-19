package inflearn

import java.util.*

object `1_9 숫자만 추출` {
    fun solution(s: String): Int? {
        val str = s.replace("[^0-9]".toRegex(), "")
        return str.toInt()
    }

    fun solution2(s: String): Int? {
        val answer = StringBuilder()
        for (ch in s.toCharArray()) {
            if (Character.isDigit(ch)) answer.append(ch)
        }
        return answer.toString().toInt()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val input = sc.next()
        println(solution(input))
    }
}