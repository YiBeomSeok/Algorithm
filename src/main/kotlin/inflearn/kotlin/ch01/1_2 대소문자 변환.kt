package inflearn.kotlin.ch01

import java.util.*

object `1_2 대소문자 변환` {
    fun solution(str: String): String {
        val answer = StringBuilder()
        for (ch in str.toCharArray()) {
            if (ch.isLowerCase())
                answer.append(ch.uppercaseChar())
            else
                answer.append(ch.lowercaseChar())
        }
        return answer.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val `in` = Scanner(System.`in`)
        val input = `in`.next()
        println(solution(input))
    }
}