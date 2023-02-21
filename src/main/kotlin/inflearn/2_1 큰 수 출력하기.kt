package inflearn

import java.util.*

object `2_1 큰 수 출력하기` {
    fun solution(ints: IntArray): IntArray {
        val answer = ArrayList<Int>()
        var prev = Int.MIN_VALUE
        for (anInt in ints) {
            if (anInt > prev) {
                answer.add(anInt)
            }
            prev = anInt
        }
        return answer.toIntArray()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextLine().toInt()
        var ints = IntArray(n)
        val st = StringTokenizer(sc.nextLine())
        for (i in 0 until n) {
            ints[i] = st.nextToken().toInt()
        }
        ints = solution(ints)
        for (anInt in ints) {
            print("$anInt ")
        }
    }
}