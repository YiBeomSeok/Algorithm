import java.util.*

data class Point(val x: Int, val y: Int)

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val m = scanner.nextInt()

    val map = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            map[i][j] = scanner.nextInt()
        }
    }

    var maxSafeArea = 0

    fun setWalls(wallCount: Int, start: Point) {
        if (wallCount == 3) {
            val safeArea = bfs(map, n, m)
            if (safeArea > maxSafeArea) {
                maxSafeArea = safeArea
            }
            return
        }

        for (i in start.x until n) {
            val jStart = if (i == start.x) start.y else 0
            for (j in jStart until m) {
                if (map[i][j] == 0) {
                    map[i][j] = 1
                    setWalls(wallCount + 1, Point(i, j))
                    map[i][j] = 0
                }
            }
        }
    }

    setWalls(0, Point(0, 0))
    println(maxSafeArea)
}

fun bfs(map: Array<IntArray>, n: Int, m: Int): Int {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val visited = Array(n) { BooleanArray(m) }
    val queue: Queue<Point> = LinkedList()

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 2) {
                queue.offer(Point(i, j))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (i in 0 until 4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]
            if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && map[nx][ny] == 0) {
                visited[nx][ny] = true
                queue.offer(Point(nx, ny))
            }
        }
    }

    var safeArea = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0 && !visited[i][j]) {
                safeArea++
            }
        }
    }

    return safeArea
}
