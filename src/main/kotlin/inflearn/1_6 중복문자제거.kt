package inflearn

import java.util.*

object `1_6 중복문자제거` {
    fun solution(input: String): String? {
        val answer = StringBuilder()
        val arrayList = ArrayList<Char>()
        for (ch in input.toCharArray()) {
            if (!arrayList.contains(ch)) arrayList.add(ch)
        }
        for (ch in arrayList) {
            answer.append(ch)
        }
        return answer.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val input = sc.next()
        println(solution(input))
    }
}