package inflearn

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

object `2_8 등수구하기` {
    fun solution(scores: IntArray): List<Int> {
        val answer: MutableList<Int> = ArrayList()
        for (i in scores.indices) {
            var rating = 1
            for (j in scores.indices) {
                if (scores[j] > scores[i]) rating++
            }
            answer.add(rating)
        }
        return answer
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val students = IntArray(n)
        val st = StringTokenizer(br.readLine())
        for (i in 0 until n) {
            students[i] = st.nextToken().toInt()
        }
        val sol = solution(students)
        for (rating in sol) {
            print("$rating ")
        }
    }
}