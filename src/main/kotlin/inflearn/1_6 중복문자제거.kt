package inflearn

import java.util.*

object `1_6 중복문자제거` {

    /**
     * indexOf(str.charAt(i))를 사용하면 해당 문자가 나타나는 가장 첫 인덱스를 반환한다.
     * 이를 이용해 이 인덱스와 현재 조사하는 인덱스 i가 같은지를 판별한다!!
     */
    fun solution(str: String): String? {
        val answer = StringBuilder()
        for (i in str.indices) {
            if (i == str.indexOf(str[i]))
                answer.append(str[i])
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