package inflearn2.kotlin.ch03.p2

import java.util.*

class Solution {
    fun solution(s: String): String {
        val stack = Stack<String>()
        var answer = ""

        s.forEach {
            if (it == ')') {
                var tmp = ""
                while (true) {
                    val ch = stack.pop()
                    if (ch == "(") break
                    tmp = "$ch$tmp"
                }
                var res = ""
                if (stack.peek()[0].isDigit()) {
                    repeat(stack.pop().toInt()) {
                        res = "$tmp$res"
                    }
                    stack.push(res)
                } else {
                    stack.push(tmp)
                }
            } else {
                stack.push("$it")
            }
        }
        stack.forEach {
            answer += it
        }
        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution("3(a2(b))ef"))
    println(T.solution("2(ab)k3(bc)"))
    println(T.solution("2(ab3((cd)))"))
    println(T.solution("2(2(ab)3(2(ac)))"))
    println(T.solution("3(ab2(sg))"))
}