package inflearn2.kotlin.ch08.p5

import java.util.*

class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(-1, 0, 1, 0)

    fun solution(board: Array<IntArray>, s: IntArray, e: IntArray): Int {
        val dist = Array(board.size) { IntArray(board[0].size) { Int.MAX_VALUE } }

        val pq = PriorityQueue<IntArray>(compareBy { it[2] })
        pq.offer(intArrayOf(s[0], s[1], 0))
        dist[s[0]][s[1]] = 0

        while (pq.isNotEmpty()) {
            val curPos = pq.poll()

            if (curPos[0] == e[0] && curPos[1] == e[1]) return curPos[2]

            for (dir in 0 until 4) {
                var nY = curPos[0]
                var nX = curPos[1]
                var d = 0

                while (nY + dy[dir] in board.indices && nX + dx[dir] in board[0].indices &&
                    board[nY + dy[dir]][nX + dx[dir]] != 1
                ) {
                    d++

                    nY += dy[dir]
                    nX += dx[dir]
                }

                if (curPos[2] + d in 1 until dist[nY][nX]) {
                    dist[nY][nX] = curPos[2] + d
                    pq.offer(intArrayOf(nY, nX, curPos[2] + d))
                }
            }
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0),
                intArrayOf(1, 0, 1, 1, 1, 0),
                intArrayOf(1, 0, 0, 0, 0, 0)
            ), intArrayOf(1, 0), intArrayOf(4, 5)
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0),
                intArrayOf(1, 0, 1, 1, 1, 0),
                intArrayOf(1, 0, 0, 0, 0, 0)
            ), intArrayOf(0, 0), intArrayOf(4, 2)
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 0, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 0),
                intArrayOf(1, 1, 0, 1, 1),
                intArrayOf(0, 0, 0, 0, 0)
            ), intArrayOf(0, 3), intArrayOf(4, 2)
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 1, 0, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0),
                intArrayOf(0, 1, 1, 0, 1, 1),
                intArrayOf(0, 0, 0, 0, 0, 0)
            ), intArrayOf(0, 0), intArrayOf(4, 5)
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 1, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 0, 0, 0, 0)
            ), intArrayOf(0, 0), intArrayOf(4, 3)
        )
    )
}