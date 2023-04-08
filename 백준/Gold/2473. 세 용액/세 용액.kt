import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt() // 용액의 개수
    val arr = br.readLine().split(" ").map{ it.toLong() }.toLongArray() // 용액의 특성값을 저장하는 배열
    
    arr.sort() // 용액을 특성값을 기준으로 오름차순 정렬

    var minSum = Long.MAX_VALUE // 가장 작은 합을 저장하는 변수
    val answer = LongArray(3) // 결과값을 저장하는 배열

    for (i in 0 until n - 2) {
        var left = i + 1 // 왼쪽 포인터
        var right = n - 1 // 오른쪽 포인터
        while (left < right) {
            val sum = arr[i] + arr[left] + arr[right] // 현재 용액 3개의 합
            if (abs(sum) < minSum) { // 현재 합이 더 작은 경우
                minSum = abs(sum)
                answer[0] = arr[i]
                answer[1] = arr[left]
                answer[2] = arr[right]
            }
            if (sum < 0) { // 합이 0보다 작은 경우, 왼쪽 포인터를 이동
                left++
            } else { // 합이 0보다 큰 경우, 오른쪽 포인터를 이동
                right--
            }
        }
    }

    println("${answer[0]} ${answer[1]} ${answer[2]}")
}
