import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt() // 용액의 개수
    val arr = br.readLine().split(" ").map{ it.toLong() }.toLongArray() // 용액의 특성값을 저장하는 배열

    arr.sort()

    var minAbs = Long.MAX_VALUE
    val answer = LongArray(3)

    var i = 0
    loop@ while(i < n - 2) {
        var left = i + 1
        var right = n - 1
        while(left < right) {
            val sum = arr[i] + arr[left] + arr[right]

            if(abs(sum) < minAbs) {
                minAbs = abs(sum)
                answer[0] = arr[i]
                answer[1] = arr[left]
                answer[2] = arr[right]
            }

            if(sum > 0) {
                right--
            } else if(sum < 0) {
                left++
            } else {
                break@loop
            }
        }
        i++
    }

    print("${answer[0]} ${answer[1]} ${answer[2]}")
}
