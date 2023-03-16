import java.io.*
import java.util.*


class Solution(val n: Int, val m: Int, val map: Array<IntArray>) {
    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)
    private val visited = Array(n) { IntArray(m) { -1 } }

    var answer = 0

    fun dfs(x: Int, y: Int): Int {
        if (x == m - 1 && y == n - 1) {
            return 1
        } else {
            visited[y][x] = 0

            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (!validateNextXY(x, y, nx, ny)) continue

                if(visited[ny][nx] == -1)
                    visited[y][x] += dfs(nx, ny)
                else
                    visited[y][x] += visited[ny][nx]
            }
        }
        return visited[y][x]
    }

    private fun validateNextXY(x: Int, y: Int, nx: Int, ny: Int): Boolean {
        if (nx >= m || nx < 0) return false
        if (ny >= n || ny < 0) return false
        if (map[y][x] <= map[ny][nx]) return false
        return true
    }
}


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until m) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    val sol = Solution(n, m, map)
    println(sol.dfs(0, 0))
}
