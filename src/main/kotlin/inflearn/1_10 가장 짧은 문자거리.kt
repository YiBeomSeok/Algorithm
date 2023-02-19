package inflearn

import java.util.*

object `1_10 가장 짧은 문자거리` {
    fun solution(s: String, t: Char): IntArray {
        val answer = IntArray(s.length)
        var p = 1000
        for (i in s.indices) {
            if (s[i] == t) {
                p = 0
            } else {
                p += 1
            }
            answer[i] = p
        }
        p = 1000
        for (i in s.length - 1 downTo 0) {
            if (s[i] == t) {
                p = 0
            } else {
                p += 1
                answer[i] = Math.min(answer[i], p)
            }
        }
        return answer
    }

    fun solutionTRESH(s: String, t: Char): String? {
        val memo = IntArray(s.length)
        Arrays.fill(memo, Int.MAX_VALUE)
        for (i in s.indices) {
            for (j in i until s.length) {
                if (s[j] == t) {
                    memo[i] = j - i
                    break
                }
            }
            for (j in i downTo 0) {
                if (s[j] == t) {
                    if (memo[i] < i - j) break
                    memo[i] = i - j
                    break
                }
            }
        }
        val answer = StringBuilder()
        for (dis in memo) {
            answer.append(dis).append(" ")
        }
        return answer.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val st = StringTokenizer(sc.nextLine())
        for (anInt in solution(st.nextToken(), st.nextToken()[0])) {
            print(anInt)
            print(" ")
        }
    }
}