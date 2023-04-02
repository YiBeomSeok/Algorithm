package inflearn2.kotlin.ch06.p5

import java.util.*

class Solution {

    lateinit var answer: MutableList<String>
    lateinit var tmp: LinkedList<String>

    fun solution(s: String): Array<String> {

        init(s)

        dfs(0, s)

        return answer.toTypedArray()
    }

    private fun init(s: String) {
        answer = mutableListOf()
        tmp = LinkedList()
    }

    private fun dfs(start: Int, s: String) {
        if(tmp.size == 4 && start == s.length) {
            var tmpStr = ""
            for(x in tmp) tmpStr += "$x."
            answer.add(tmpStr.dropLast(1))
        } else {
            for(i in start until s.length) {
                if(s[start] == '0' && i > start) return
                val num = s.substring(start, i + 1)
                if(num.toInt() > 255) return
                tmp.add(num)
                dfs(i + 1, s)
                tmp.pollLast()
            }
        }
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(Arrays.toString(T.solution("2025505")))
    println(Arrays.toString(T.solution("0000")))
    println(Arrays.toString(T.solution("255003")))
    println(Arrays.toString(T.solution("155032012")))
    println(Arrays.toString(T.solution("02325123")))
    println(Arrays.toString(T.solution("121431211")))
}