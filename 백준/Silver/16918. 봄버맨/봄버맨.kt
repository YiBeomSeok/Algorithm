import java.io.*
import java.util.*

//09:57
val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(-1, 0, 1, 0)
class Point(val y: Int, val x: Int) { }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val board = Array(r) { CharArray(c) }
    for(i in 0 until r) {
        val line = br.readLine()
        for(j in 0 until c) {
            board[i][j] = line[j]
        }
    }

    val timerBoard = Array(r) { IntArray(c) { -1 } }
    val queue = ArrayDeque<Point>()
    for(i in 0 until r) {
        for(j in 0 until c) {
            if(board[i][j] == 'O') {
                queue.addLast(Point(i, j))
                timerBoard[i][j] = 1
            }
        }
    }

//    timerBoard.forEach { row ->
//        row.forEach {
//            print("$it ")
//        }
//        println()
//    }

    sol(r, c, n, timerBoard, queue)

//    timerBoard.forEach { row ->
//        row.forEach {
//            print("$it ")
//        }
//        println()
//    }

    timerBoard.forEach { row ->
        row.forEach {
            if(it == -1) print(".")
            else print("O")
        }
        println()
    }
}

fun sol(r: Int, c: Int, n: Int, timerBoard: Array<IntArray>, queue: Queue<Point>) {
    var curTime = 0

    while(curTime < n - 1) {

        for(i in 0 until r) {
            for(j in 0 until c) {
                timerBoard[i][j]++
            }
        }

        for(i in 0 until r) {
            for(j in 0 until c) {

                if(timerBoard[i][j] == 3) {
                    timerBoard[i][j] = -1
                    for(offset in 0 until 4) {
                        val nx = j + dx[offset]
                        val ny = i + dy[offset]

                        if(nx < 0 || nx == c) continue
                        if(ny < 0 || ny == r) continue
                        if(timerBoard[ny][nx] == 3) continue

                        timerBoard[ny][nx] = -1
                    }
                }
            }
        }
        curTime++
    }
}
