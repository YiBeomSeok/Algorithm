
import java.io.*
import java.util.*

class Solution(val n: Int, val m: Int, val l: Int, val restAreas: IntArray) {
    fun solution(): Int {
        restAreas.sort()

        var left = 1
        var right = l - 1
        var answer = 0
        while(left <= right) {
            val mid = (right + left) / 2

            var cnt = 0
            for(i in 1 ..n + 1) {
                val distance = restAreas[i] - restAreas[i - 1]
                cnt += (distance - 1) / mid
            }
            if(cnt > m) {
                left = mid + 1

            } else {
                right = mid - 1
                answer = mid
            }
        }
        return answer
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val l = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val restAreas = IntArray(n + 2)
    for(i in 1 until n + 1) {
        restAreas[i] = st.nextToken().toInt()
    }
    restAreas[n + 1] = l

    val sol = Solution(n, m, l, restAreas)
    println(sol.solution())
}