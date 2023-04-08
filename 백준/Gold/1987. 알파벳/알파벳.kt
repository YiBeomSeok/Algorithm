import java.io.*
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
var answer = 0

val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(-1, 0, 1, 0)
val visited = BooleanArray('Z'.code + 1)

fun main() {
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(r) {
        br.readLine()
    }

    visited[board[0][0].code] = true
    answer = 1

    dfs(0, 0, 1, board)

    print(answer)
}

fun dfs(curY: Int, curX: Int, count: Int, board: Array<String>) {
    var isEnd = 0
    for(dir in 0 until 4) {
        val nY = curY + dy[dir]
        val nX = curX + dx[dir]

        if(nY in board.indices && nX in board[0].indices && !visited[board[nY][nX].code]) {
            visited[board[nY][nX].code] = true
            dfs(nY, nX, count + 1, board)
            visited[board[nY][nX].code] = false
        } else {
            isEnd++
        }
    }
    if(isEnd == 4) {
        answer = maxOf(count, answer)
    }
}
