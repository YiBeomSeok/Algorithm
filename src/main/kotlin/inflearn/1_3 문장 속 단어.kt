package inflearn

import java.util.*

object `1_3 문장 속 단어` {
    fun solution(str: String): String? {
        val strArray = str.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        var max = strArray[0]
        for (elem in strArray) {
            if (elem.length > max.length) max = elem
        }
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val input = sc.nextLine()
        println(solution(input))
        return
    }
}