package inflearn.kotlin.ch08

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Maze {
    companion object {
        private const val LAST = 7
        private val dx = intArrayOf(1, 0, -1, 0)
        private val dy = intArrayOf(0, 1, 0, -1)

        fun solve(): Int {
            val br = BufferedReader(InputStreamReader(System.`in`))
            var st: StringTokenizer
            val board = Array(LAST + 1) { IntArray(LAST + 1) }

            for (i in 1..LAST) {
                st = StringTokenizer(br.readLine())
                for (j in 1..LAST) {
                    board[i][j] = st.nextToken().toInt()
                }
            }

            return bfs(board)
        }

        private fun bfs(board: Array<IntArray>): Int {
            var curPoint = Point(1, 1)
            val distance = Array(LAST + 1) { IntArray(LAST + 1) { 0 } }
            board[curPoint.y][curPoint.x] = 1
            val deque = ArrayDeque<Point>()

            deque.addLast(curPoint)

            while (deque.isNotEmpty()) {
                curPoint = deque.removeFirst()

                if (curPoint.y == LAST && curPoint.x == LAST) return distance[curPoint.y][curPoint.x]

                for (i in 0 until 4) {
                    val nextY = curPoint.y + dy[i]
                    val nextX = curPoint.x + dx[i]

                    if (nextY == 0 || nextY == LAST + 1) continue
                    if (nextX == 0 || nextX == LAST + 1) continue
                    if (board[nextY][nextX] == 1) continue

                    board[nextY][nextX] = 1
                    distance[nextY][nextX] = distance[curPoint.y][curPoint.x] + 1
                    deque.addLast(Point(nextY, nextX))
                }
            }
            return -1
        }
    }
}

data class Point(val y: Int, val x: Int)

fun main() {
    println(Maze.solve())
}