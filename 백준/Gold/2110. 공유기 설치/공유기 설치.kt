import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val nc = reader.readLine().split(" ")
    val n = nc[0].toInt()
    val c = nc[1].toInt()
    val coordinate = LongArray(n) {
        reader.readLine().toLong()
    }

    println(solution(n, c, coordinate))
}

fun solution(n: Int, c: Int, coordinate: LongArray): Long {
    var answer: Long = 0

    coordinate.sort()
    var min: Long = 1
    var max: Long = coordinate[n - 1] - coordinate[0]

    while (min <= max) {
        val mid: Long = (max + min) / 2
        var start = coordinate[0]
        var count = 1
        for (i in 1 until n) {
            if (coordinate[i] - start >= mid) {
                start = coordinate[i]
                count++
            }
        }

        if (count >= c) {
            answer = mid
            min = mid + 1
        } else {
            max = mid - 1
        }
    }

    return answer
}