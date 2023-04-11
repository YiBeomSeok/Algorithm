import java.util.*

class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        val floyd = Array(n+1) { IntArray(n+1) }

        for (result in results) {
            val A = result[0]
            val B = result[1]
            // A > B
            floyd[A][B] = 1
            floyd[B][A] = -1
        }

        // 4 > 3 , 3 > 2 => 4 > 2
        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    if (floyd[i][k] == 1 && floyd[k][j] == 1) {
                        floyd[i][j] = 1
                        floyd[j][i] = -1
                    }
                    if (floyd[i][k] == -1 && floyd[k][j] == -1) {
                        floyd[i][j] = -1
                        floyd[j][i] = 1
                    }
                }
            }
        }

        for (i in 1..n) {
            var cnt = 0
            for (j in 1..n) {
                if (floyd[i][j] != 0) cnt++
            }
            if (cnt == n-1) answer++
        }

        return answer
    }

}