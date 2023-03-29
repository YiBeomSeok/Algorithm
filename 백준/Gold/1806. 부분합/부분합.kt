import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    var left = 0
    var right = 0
    var sum = arr[0]
    var len = Int.MAX_VALUE

    while (left <= right && right < n) {
        if (sum < s) {
            right++
            if (right < n) sum += arr[right]
        } else if (sum == s) {
            len = minOf(len, right - left + 1)
            right++
            if (right < n) sum += arr[right]
        } else {
            len = minOf(len, right - left + 1)
            sum -= arr[left]
            left++
        }
    }

    if (len == Int.MAX_VALUE) {
        println(0)
    } else {
        println(len)
    }
}
