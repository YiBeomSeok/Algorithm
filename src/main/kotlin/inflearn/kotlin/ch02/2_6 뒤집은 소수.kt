package inflearn.kotlin.ch02

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

object `2_6 뒤집은 소수` {
    fun solution(intArray: IntArray): IntArray {
        for (i in intArray.indices) {
            intArray[i] = "${intArray[i]}".reversed().toInt()
        }

        val max = intArray.max()
        val ch = IntArray(max + 1)
        ch[0] = 1
        ch[1] = 1
        for (i in 2..max) {
            if (ch[i] == 0) {
                var j = i + i
                while (j <= max) {
                    ch[j] = 1
                    j += i
                }
            }
        }
        val answer = ArrayList<Int>()
        for (i in intArray.indices) {
            if (ch[intArray[i]] == 0) answer.add(intArray[i])
        }
        return answer.toIntArray()
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val st = StringTokenizer(br.readLine())
        val input = IntArray(n)
        for (i in 0 until n) {
            input[i] = st.nextToken().toInt()
        }
        val sol = solution(input)
        for (anInt in sol) {
            print("$anInt ")
        }
    }
}