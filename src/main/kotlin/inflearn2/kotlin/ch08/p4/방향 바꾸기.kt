package inflearn2.kotlin.ch08.p4

import java.util.*

class Solution {
    val dx = intArrayOf(0, 1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 0, 1, -1)

    fun solution(board: Array<IntArray>): Int {

        val visited = Array(board.size) { IntArray(board[0].size) }

        val pq = PriorityQueue<IntArray>(compareBy { it[2] })
        pq.offer(intArrayOf(0, 0, 0))

        while (pq.isNotEmpty()) {
            val curPos = pq.poll()

            if (curPos[0] == board.size - 1 && curPos[1] == board[0].size - 1) {
                return curPos[2]
            }

            if(visited[curPos[0]][curPos[1]] == 1) continue
            visited[curPos[0]][curPos[1]] = 1

            for (dir in 1 until 5) {
                val nY = curPos[0] + dy[dir]
                val nX = curPos[1] + dx[dir]

                if (nY in board.indices && nX in board[0].indices && visited[nY][nX] == 0) {
                    if (dir != board[curPos[0]][curPos[1]]) {
                        pq.add(intArrayOf(nY, nX, curPos[2] + 1))
                    } else {
                        pq.add(intArrayOf(nY, nX, curPos[2]))
                    }
                }
            }

        }

        return -1
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(arrayOf(intArrayOf(3, 1, 3), intArrayOf(1, 4, 2), intArrayOf(4, 2, 3))))
    println(
        T.solution(
            arrayOf(
                intArrayOf(3, 2, 1, 3),
                intArrayOf(1, 1, 4, 2),
                intArrayOf(3, 4, 2, 1),
                intArrayOf(1, 2, 2, 4)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(3, 2, 1, 3, 1, 2),
                intArrayOf(2, 1, 1, 1, 4, 2),
                intArrayOf(2, 2, 2, 1, 2, 2),
                intArrayOf(1, 3, 3, 4, 4, 4),
                intArrayOf(1, 2, 2, 3, 3, 4)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(3, 2, 1, 3, 1, 2, 2, 2),
                intArrayOf(2, 1, 1, 1, 4, 2, 1, 1),
                intArrayOf(2, 2, 2, 1, 2, 2, 3, 4),
                intArrayOf(1, 3, 3, 4, 4, 4, 3, 1),
                intArrayOf(1, 2, 2, 3, 3, 4, 3, 4),
                intArrayOf(1, 2, 2, 3, 3, 1, 1, 1)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 2, 3, 2, 1, 3, 1, 2, 2, 2),
                intArrayOf(1, 2, 2, 1, 1, 1, 4, 2, 1, 1),
                intArrayOf(3, 2, 2, 2, 2, 1, 2, 2, 3, 4),
                intArrayOf(3, 3, 1, 3, 3, 4, 4, 4, 3, 1),
                intArrayOf(1, 1, 1, 2, 2, 3, 3, 4, 3, 4),
                intArrayOf(1, 1, 1, 2, 2, 3, 3, 1, 1, 1)
            )
        )
    )
}