
import java.io.*
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

class Solution(val n: Int, val m: Int, val inputs: Array<IntArray>) {
    fun solution(): Int {
        val dp = IntArray(m + 1) { 0 }

        for(i in 0 until n) {
            val weightNeeded = inputs[i][0]
            val value = inputs[i][1]
            for(j in m downTo weightNeeded) {
                if(dp[j - weightNeeded] + value > dp[j]) {
                    dp[j] = dp[j - weightNeeded] + value
                }
            }
        }

        return dp[m]
    }
}

fun main() {
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val inputs = Array(n) {
        st = StringTokenizer(br.readLine())
        IntArray(2) {
            st.nextToken().toInt()
        }
    }

    val sol = Solution(n, m, inputs)
    print(sol.solution())
}