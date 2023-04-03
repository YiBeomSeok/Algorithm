package inflearn2.kotlin.ch07.p5

class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(-1, 0, 1, 0)

    fun solution(board: Array<IntArray>): Int {
        var answer = -1
        val dist = Array(board.size) { IntArray(board.size) }
        var emptyLand = 0

        board.forEachIndexed { y, line ->
            line.forEachIndexed { x, value ->
                if (value == 1) {
                    with(bfs(intArrayOf(y, x), emptyLand, board, dist)) {
                        if(this == -1) return -1
                        answer = this
                    }
                    emptyLand--
                }
            }
        }

        return answer
    }

    private fun bfs(curBuilding: IntArray, emptyLand: Int, board: Array<IntArray>, dist: Array<IntArray>): Int {
        var result = Int.MAX_VALUE

        val deque = ArrayDeque<IntArray>()
        deque.add(curBuilding)

        var depth = 0
        while (deque.isNotEmpty()) {
            val len = deque.size
            depth++

            repeat(len) {
                val curPos = deque.removeFirst()

                for (dir in 0 until 4) {
                    val nextPos = intArrayOf(curPos[0] + dy[dir], curPos[1] + dx[dir])

                    if(nextPos[0] in board.indices && nextPos[1] in board.indices && board[nextPos[0]][nextPos[1]] == emptyLand) {
                        board[nextPos[0]][nextPos[1]] = emptyLand - 1
                        dist[nextPos[0]][nextPos[1]] += depth

                        result = minOf(result, dist[nextPos[0]][nextPos[1]])
                        deque.add(nextPos)
                    }
                }
            }
        }

        return if(result == Int.MAX_VALUE) -1 else result
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 0, 2, 0, 1),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 2, 1, 0, 0),
                intArrayOf(2, 0, 0, 2, 2),
                intArrayOf(0, 0, 0, 0, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 0, 0, 1),
                intArrayOf(0, 0, 2, 0),
                intArrayOf(0, 0, 1, 0),
                intArrayOf(2, 2, 0, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 2, 0, 0),
                intArrayOf(0, 0, 1, 2),
                intArrayOf(0, 2, 0, 0),
                intArrayOf(0, 2, 1, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 0, 0, 1),
                intArrayOf(0, 0, 2, 0),
                intArrayOf(0, 0, 1, 0),
                intArrayOf(2, 2, 0, 1)
            )
        )
    )
}