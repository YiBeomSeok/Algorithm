package inflearn2.kotlin.ch03.p2

import java.util.*

class Solution {
    fun solution(s: String): String {
        val stack = Stack<String>()
        var answer = ""

        s.forEach {
            if(it == ')') {
                var tmp = ""
                while(stack.isNotEmpty()) {
                    val c = stack.pop()
                    if(c == "(") {
                        var num = ""
                        while(stack.isNotEmpty() && stack.peek()[0].isDigit()) {
                            num = stack.pop() + num
                        }
                        var res = ""
                        var cnt = 0
                        if(num == "") cnt = 1
                        else cnt = num.toInt()

                        for(i in 0 until cnt) {
                            res += tmp
                        }

                        stack.push(res)
                        break
                    }
                    tmp = c + tmp
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