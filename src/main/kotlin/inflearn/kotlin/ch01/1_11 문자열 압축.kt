package inflearn.kotlin.ch01

import java.util.*

object `1_11 문자열 압축` {
    fun solution(str: String): String {
        val s = "$str "
        val sb = StringBuilder()
        var cnt = 1
        for (i in 0 until s.length - 1) {
            if (s[i] == s[i + 1]) cnt++ else {
                sb.append(s[i])
                if (cnt > 1) sb.append(cnt)
                cnt = 1
            }
        }
        return sb.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val input = sc.next()
        println(solution(input))
    }
}