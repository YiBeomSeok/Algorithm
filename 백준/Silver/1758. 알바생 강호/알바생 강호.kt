import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val tip = IntArray(n)

    for(i in 0 until n) {
        tip[i] = br.readLine().toInt()
    }
    tip.sortDescending()
    var answer = 0L
    for(i in tip.indices) {
        with(tip[i] - i) {
            if(this > 0) answer += this
        }
    }

    print(answer)
}