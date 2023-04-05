import java.util.*
import java.io.*

val br = BufferedReader(InputStreamReader(System.`in`))
val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(-1, 0, 1, 0)

val boundary = ArrayDeque<Point>()

fun main() {
    val n = br.readLine().toInt()
    val board = Array(n) {
        val st = StringTokenizer(br.readLine())
        IntArray(n) { st.nextToken().toInt() }
    }

    var landNum = 2
    for(i in 0 until n) {
        for(j in 0 until n) {
            if(board[i][j] == 1) {
                markingLand(i, j, landNum, board)
                landNum++
            }
        }
    }

    println(bfsAll(board))
}

fun bfsAll(board: Array<IntArray>): Int {
    var level = 0
    val dist = Array(board.size) { IntArray(board.size) }
    var min = Int.MAX_VALUE
    while(boundary.isNotEmpty()) {
        val len = boundary.size
        level++
        repeat(len) {
            val curPoint = boundary.removeFirst()

            for(dir in 0 until 4) {
                val nY = curPoint.y + dy[dir]
                val nX = curPoint.x + dx[dir]

                if(nY in board.indices && nX in board.indices) {
                    if(board[nY][nX] == 0) {
                        board[nY][nX] = curPoint.land
                        dist[nY][nX] = level
                        boundary.addLast(Point(nY, nX, curPoint.land))
                    } else if(board[nY][nX] != curPoint.land) {
                        min = minOf(min, dist[curPoint.y][curPoint.x] + dist[nY][nX])
                    }
                }
            }
        }
    }

    return min
}

fun markingLand(sY: Int, sX: Int, landNum: Int, board: Array<IntArray>) {
    val deque = ArrayDeque<IntArray>()
    deque.addLast(intArrayOf(sY, sX))
    board[sY][sX] = landNum
    while(deque.isNotEmpty()) {

        val len = deque.size
        repeat(len) {
            val curPos = deque.removeFirst()
            var isBoundary = false
            for(dir in 0 until 4) {
                val nY = curPos[0] + dy[dir]
                val nX = curPos[1] + dx[dir]

                if(nY in board.indices && nX in board.indices) {
                    if(board[nY][nX] == 1) {
                        board[nY][nX] = landNum
                        deque.add(intArrayOf(nY, nX))
                    } else {
                        isBoundary = true
                    }
                }
            }
            if(isBoundary) {
                boundary.add(Point(curPos[0], curPos[1], landNum))
            }
        }
    }
}
class Point(val y: Int, val x: Int, val land: Int)