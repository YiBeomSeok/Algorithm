
import java.io.*
import java.util.*

class Tomato(val n: Int, val m: Int, val board: Array<IntArray>) {
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val dis = Array(n + 1) { IntArray(m + 1) }

    fun bfs(): Int {

        val deque = ArrayDeque<Point>()

        for (i in 1..n) {
            for (j in 1..m) {
                if (board[i][j] == 1) deque.add(Point(i, j))
            }
        }

        while(deque.isNotEmpty()) {
            val curPoint = deque.removeFirst()

            for(i in 0 until 4) {
                val nextY = curPoint.y + dy[i]
                val nextX = curPoint.x + dx[i]

                if(nextY == 0 || nextY == n + 1) continue
                if(nextX == 0 || nextX == m + 1) continue
                if(board[nextY][nextX] != 0) continue

                board[nextY][nextX] = 1
                deque.addLast(Point(nextY, nextX))
                dis[nextY][nextX] = dis[curPoint.y][curPoint.x] + 1
            }
        }

        var flag = true

        var answer = Int.MIN_VALUE
        for (i in 1..n) {
            for (j in 1..m) {
                if (board[i][j] == 0) {
                    flag = false
                    break
                }
            }
        }

        if (flag) {
            for (i in 1..n) {
                for(j in 1 .. m) {
                    answer = maxOf(answer, dis[i][j])
                }
            }
            return answer
        }

        return -1
    }

    data class Point(val y: Int, val x: Int)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    st = StringTokenizer(br.readLine())
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val board = Array(n + 1) { IntArray(m + 1) }
    for (i in 1..n) {
        st = StringTokenizer(br.readLine())
        for (j in 1..m) {
            board[i][j] = st.nextToken().toInt()
        }
    }

    val tomatoBoard = Tomato(n, m, board)
    print(tomatoBoard.bfs())
}