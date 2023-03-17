import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    repeat(n) {
        val st = StringTokenizer(readLine())
        while (st.hasMoreTokens()) {
            print(st.nextToken().reversed() + " ")
        }
        println()
    }
}
