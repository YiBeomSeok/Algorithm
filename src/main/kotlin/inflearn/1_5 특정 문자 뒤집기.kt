package inflearn

import java.util.*

object `1_5 특정 문자 뒤집기` {
    fun solution(input: String): String? {
        val chars = input.toCharArray()
        var lt = 0
        var rt = input.length - 1
        while (lt < rt) {
            if (!Character.isAlphabetic(chars[lt].code))
                lt++
            else if (!Character.isAlphabetic(chars[rt].code))
                rt--
            else {
                val tmp = chars[lt]
                chars[lt] = chars[rt]
                chars[rt] = tmp
                lt++
                rt--
            }
        }
        return String(chars)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val input = sc.next()
        println(solution(input))
    }
}