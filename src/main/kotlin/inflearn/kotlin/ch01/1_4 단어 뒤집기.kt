package inflearn.kotlin.ch01

import java.util.*

object `1_4 단어 뒤집기` {
    fun solution(input: List<String>): List<String> {
        val answer = mutableListOf<String>()
        for (str in input) {
            answer.add(StringBuilder(str).reverse().toString())
        }
        return answer
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val input: MutableList<String> = ArrayList()
        for (i in 0 until n) {
            input.add(sc.next())
        }
        for (str in solution(input)) {
            println(str)
        }
    }
}