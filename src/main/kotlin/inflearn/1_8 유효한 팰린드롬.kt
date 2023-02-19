package inflearn

import inflearn.java._1_8_유효한_팰린드롬
import java.util.*

object `1_8 유효한 팰린드롬` {
    fun solution(str: String): String {
        val sb = StringBuilder(str)
        sb.reverse()
        return if (sb.toString().equals(str, ignoreCase = true)) "YES" else "NO"
    }

    /**
     * 정규식을 활용하는 방법
     * ^ -> 아닌 것들
     * [^A-Z] -> A부터 Z 까지가 아닌 것들
     * @param s
     * @return
     */
    fun solution2(s: String): String {
        val str = s.uppercase().replace(regex = "[^A-Z]".toRegex(), replacement = "")
        val tmp = StringBuilder(str).reverse().toString()
        return if (str == tmp) "YES" else "NO"
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val input = sc.nextLine()
        println(solution(input))
    }
}