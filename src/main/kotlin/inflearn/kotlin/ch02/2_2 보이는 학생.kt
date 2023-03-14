package inflearn.kotlin.ch02

import java.util.*

object `2_2 보이는 학생` {
    fun solution(ints: IntArray): Int {
        var prev = Int.MIN_VALUE
        var answer = 0
        for (cm in ints) {
            if (cm > prev) {
                answer++
                prev = cm
            }
        }
        return answer
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextLine().toInt()
        val st = StringTokenizer(sc.nextLine())
        val ints = IntArray(n)
        for (i in 0 until n) {
            ints[i] = st.nextToken().toInt()
        }
        println(solution(ints))
    }
}