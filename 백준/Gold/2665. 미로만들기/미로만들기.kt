import java.io.*
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

class Point(
    val y: Int,
    val x: Int,
    var changeCount: Int,
) : Comparable<Point> {

    override fun compareTo(other: Point): Int {
        return if (other.changeCount == this.changeCount) {
            other.x - this.x
        } else {
            this.changeCount - other.changeCount
        }
    }
}

class Solution(val n: Int, val board: Array<IntArray>) {
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun solution(): Int {
        return bfs()
    }

    private fun bfs(): Int {
        val check = Array(n) { IntArray(n) { Int.MAX_VALUE } }
        check[0][0] = 0

        val pq = PriorityQueue<Point>()
        pq.offer(Point(0, 0, 0))

        while(pq.isNotEmpty()) {
            val curPoint = pq.poll()

            if(curPoint.y == n - 1 && curPoint.x == n - 1) return curPoint.changeCount

            for(dir in 0 until 4) {
                val nextY = curPoint.y + dy[dir]
                val nextX = curPoint.x + dx[dir]

                if(nextY == -1 || nextY == n) continue
                if(nextX == -1 || nextX == n) continue

                val nextPoint = if(board[nextY][nextX] == 0) {
                    Point(nextY, nextX, curPoint.changeCount + 1)
                } else {
                    Point(nextY, nextX, curPoint.changeCount)
                }
                
                if(nextPoint.changeCount < check[nextY][nextX]) {
                    check[nextY][nextX] = nextPoint.changeCount
                    pq.offer(nextPoint)
                }
            }
        }

        return -1
    }
}

fun main() {
    val n = br.readLine().toInt()

    val board = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val line = br.readLine()
        for (j in 0 until n) {
            board[i][j] = line[j] - '0'
        }
    }

    val sol = Solution(n, board)
    print(sol.solution())
}