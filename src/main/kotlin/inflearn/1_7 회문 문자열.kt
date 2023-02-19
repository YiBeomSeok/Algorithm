package inflearn

import java.util.*

object `1_7 회문 문자열` {
    fun solution(str: String?): String? {
        val sb = StringBuilder(str)
        sb.reverse()
        return if (sb.toString().equals(str, ignoreCase = true)) "YES" else "NO"
    }

    fun solution2(str: String): String? {
        var str = str
        val len = str.length
        str = str.uppercase(Locale.getDefault())
        for (i in 0 until len / 2) {
            if (str[i] != str[len - i - 1]) return "NO"
        }
        return "YES"
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val input = sc.next()
        println(solution(input))
    }
}