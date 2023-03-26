import java.io.*
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val dp = IntArray(n) { 1 }
    val ch = IntArray(n) { it }
    val permutation = IntArray(n) {
        st.nextToken().toInt()
    }

    var max = n - 1
    for (i in n - 1 downTo 0) {
        for (j in i + 1 until n) {
            if(permutation[j] > permutation[i] && dp[i] <= dp[j]) {
                dp[i] = dp[j] + 1
                ch[i] = j
                if(dp[i] > dp[max]) max = i
            }
        }
    }

    println(dp[max])
    var start = max
    while(true) {
        print("${permutation[start]} ")
        if(start == ch[start]) break
        start = ch[start]
    }
}
