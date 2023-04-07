import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val switches = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val bulbs = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val switchesIndexed = IntArray(n)
    switches.forEachIndexed { i, value ->
        switchesIndexed[i] = bulbs.indexOf(value)
    }

    val dp = IntArray(n)
    val prev = IntArray(n) { -1 }

    var len = 1
    for(i in 1 until n) {
        if(switchesIndexed[i] < switchesIndexed[dp[0]]) {
            dp[0] = i
        } else if(switchesIndexed[i] > switchesIndexed[dp[len - 1]]) {
            prev[i] = dp[len - 1]
            dp[len++] = i
        } else {
            var left = 0
            var right = len - 1
            while(left < right) {
                val mid = (left + right) / 2

                if(switchesIndexed[dp[mid]] < switchesIndexed[i]) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }

            prev[i] = dp[left - 1]
            dp[left] = i
        }
    }
    val lis = mutableListOf<Int>()
    var i = dp[len - 1]
    while(i != -1) {
        lis.add(bulbs[switchesIndexed[i]])
        i = prev[i]
    }
    lis.sort()

    println(lis.size)
    print(lis.joinToString(" "))
}