import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val sb = StringBuilder()
    for (i in 2..n) {
        while (n % i == 0) {
            sb.append("$i\n")
            n /= i
        }
    }

    print(sb)
}