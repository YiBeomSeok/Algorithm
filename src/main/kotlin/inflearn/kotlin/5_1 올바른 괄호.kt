package inflearn.kotlin

import inflearn.java.ch05_stack_queue._5_1_올바른_괄호
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object `5_1 올바른 괄호` {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (c in s) {
            when (c) {
                '(', '{', '[' -> stack.push(c)
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
                '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
                ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
            }
        }

        return stack.isEmpty()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val input = br.readLine()
        val result = _5_1_올바른_괄호.solution(input)

        if (result) println("YES") else println("NO")
    }
}