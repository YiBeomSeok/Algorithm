package inflearn.kotlin.ch07_recursive

import java.io.BufferedReader
import java.io.InputStreamReader

class CowFinder {

    // 아래에 더 나은 코드가 존재함
    fun findMin(start: Int, end: Int): Int {
        val queue = ArrayDeque<Int>()
        queue.add(start)
        var count = 0
        while (queue.isNotEmpty()) {

            val size = queue.size
            for (i in 0 until size) {
                val cur = queue.removeLast()

                if (cur < end) {
                    if (cur > end.minus(5)) {
                        queue.add(cur + 1)
                    }
                    queue.add(cur.plus(5))
                } else if (cur > end) {
                    queue.add(cur.minus(1))
                } else {    // cur == end
                    return count
                }
            }
            count++
        }

        return -1
    }

    // 더 효율적인 코드
    fun findMin2(start: Int, end: Int): Int {
        val dis = intArrayOf(1, -1, 5)
        val visited = IntArray(10001) { 0 }
        val queue = ArrayDeque<Int>()

        visited[start] = 1
        queue.addLast(start)
        var count = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (i in 0 until size) {
                val cur = queue.removeFirst()

                for (i in 0 until 3) {
                    val next = cur.plus(dis[i])
                    if(next == end) return count.inc()
                    if (next in 1..10000 && visited[next] == 0) {
                        visited[next] = 1
                        queue.addLast(next)
                    }
                }
            }
            count++
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val split = reader.readLine().split(" ")
    val s = split[0].toInt()
    val e = split[1].toInt()

    val finder = CowFinder()
    val count = finder.findMin(start = s, end = e)

    println(count)
}