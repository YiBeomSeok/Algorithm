import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.System.`in`

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(`in`))

    val n = br.readLine().toInt()
    val intArray = (0 until n).map {
        br.readLine().toInt()
    }.toIntArray()

    println(solution(n, intArray))
}

// 정답은 항상 2^31보다 작으므로 32 비트 사용하는 Int로 표현 가능하다.
fun solution(n: Int, arr: IntArray): Int {
    var answer = 0
    var zeros = 0
    var i = 0
    val sorted = arr.sortedDescending()
    while(i < sorted.size) {
        val top = sorted[i]
        if(top > 0) {
            if((i + 1) < sorted.size && sorted[i + 1] > 1) {
                answer += top * sorted[i + 1]
                i++
            } else {
                answer += top
            }
        } else if(top == 0) {
            zeros++
        } else {
            break
        }
        i++
    }
    i = sorted.size - 1
    while(i >= 0) {
        val bottom = sorted[i]
        if(bottom < 0) {
            if((i - 1) >= 0 && sorted[i - 1] < 0) {
                answer += bottom * sorted[i - 1]
                i--
            } else {
                if(zeros == 0)
                    answer += bottom
                break
            }
        }
        i--
    }
    return answer
}