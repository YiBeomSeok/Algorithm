package inflearn.kotlin.ch01

import java.util.*

class `1_1 문자찾기` {

    private fun solution(str: String, t: Char): Int {
        var answer = 0

        val str = str.uppercase()
        val t = t.uppercaseChar()
        for (ch in str.toCharArray()) {
            if (ch == t) answer++
        }
        return answer
    }

    fun main(args: Array<String>) {
        val kb = Scanner(System.`in`)
        val str = kb.next()
        val c = kb.next()[0]
        print(solution(str, c))
    }
}