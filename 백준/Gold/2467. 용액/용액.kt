import java.io.*
import java.util.*
import kotlin.math.abs

val br = BufferedReader(InputStreamReader(System.`in`))

class Solution(val n: Int, val arr: LongArray) {
    fun solution(): LongArray {

        var left = 0
        var right = arr.size - 1

        var goodLeft = 0
        var goodRight = arr.size - 1
        var good: Long = abs(arr[goodLeft] + arr[goodRight])

        while(left < right) {
            val sum: Long = arr[left] + arr[right]
            if(abs(sum) <= good) {
                good = abs(sum)
                goodLeft = left
                goodRight = right
            }

            if(sum < 0) {
                left++
            } else if (sum > 0) {
                right--
            } else {
                return longArrayOf(arr[left], arr[right])
            }
        }

        return longArrayOf(arr[goodLeft], arr[goodRight])
    }
}
fun main() {
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val arr = LongArray(n) {
        st.nextToken().toLong()
    }

    val sol = Solution(n, arr)
    val ans = sol.solution()
    print("${ans[0]} ${ans[1]}")
}