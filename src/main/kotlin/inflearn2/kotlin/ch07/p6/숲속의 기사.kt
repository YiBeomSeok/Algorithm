package inflearn2.kotlin.ch07.p6

class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(-1, 0, 1, 0)

    fun solution(board: Array<IntArray>): Int {
        val dist = Array(board.size) { IntArray(board[0].size) }
        val berryPoses = mutableListOf<IntArray>()

        board.forEachIndexed { y, line ->
            line.forEachIndexed { x, value ->
                if(value == 4) {
                    berryPoses.add(intArrayOf(y, x))
                } else if(value == 2 || value == 3) {
                    bfs(intArrayOf(y, x), board, dist)
                }
            }
        }

        var answer = Int.MAX_VALUE
        berryPoses.forEach {
            if(dist[it[0]][it[1]] > 0)
               answer = minOf(answer, dist[it[0]][it[1]])
        }

        return answer
    }

    private fun bfs(stPos: IntArray, board: Array<IntArray>, dist: Array<IntArray>) {
        val visited = Array(board.size) { IntArray(board[0].size) }

        val deque = ArrayDeque<IntArray>()
        deque.addLast(stPos)
        visited[stPos[0]][stPos[1]] = 1

        var depth = 0
        while(deque.isNotEmpty()) {
            depth++

            val len = deque.size
            repeat(len) {
                val curPos = deque.removeFirst()

                for(dir in 0 until 4) {
                    val nY = curPos[0] + dy[dir]
                    val nX = curPos[1] + dx[dir]

                    if(nY in board.indices && nX in board[0].indices && board[nY][nX] != 1 && visited[nY][nX] == 0) {
                        dist[nY][nX] += depth
                        visited[nY][nX] = 1

                        deque.addLast(intArrayOf(nY, nX))
                    }
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(4, 1, 0, 0, 0, 0, 1, 0),
                intArrayOf(0, 0, 0, 1, 0, 1, 0, 0),
                intArrayOf(0, 2, 1, 1, 3, 0, 4, 0),
                intArrayOf(0, 0, 0, 4, 1, 1, 1, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(3, 0, 0, 0, 1, 4, 4, 4),
                intArrayOf(0, 1, 1, 0, 0, 0, 1, 0),
                intArrayOf(0, 1, 4, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 0, 0, 0, 0),
                intArrayOf(1, 0, 1, 0, 0, 1, 1, 0),
                intArrayOf(4, 0, 0, 0, 1, 0, 0, 0),
                intArrayOf(4, 1, 0, 0, 1, 0, 0, 0),
                intArrayOf(4, 0, 0, 0, 0, 0, 1, 2)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(4, 1, 0, 1, 0),
                intArrayOf(0, 1, 0, 1, 0),
                intArrayOf(0, 0, 2, 3, 4),
                intArrayOf(0, 1, 0, 1, 0)
            )
        )
    )
}