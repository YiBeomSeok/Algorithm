import java.io.*
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val n = br.readLine().toInt()

    var current = n
    var count = 0
    while(true) {
        val first = current.div(10)
        val second = current.rem(10)
        val third = (first + second).rem(10)

        current = second * 10 + third
        count++

        if(current == n) break
    }
    println(count)
}