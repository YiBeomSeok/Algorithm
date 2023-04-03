package inflearn2.kotlin.ch08.p3

import java.util.*

class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(-1, 0, 1, 0)

    fun solution(board: Array<IntArray>): Int {
        val pq = PriorityQueue<IntArray>( compareBy { it[2] })
        pq.offer(intArrayOf(0, 0, 0))

        while(pq.isNotEmpty()) {
            val curPos = pq.poll()
            if(curPos[0] == board.size - 1 && curPos[1] == board[0].size - 1) {
                return curPos[2]
            }

            for(dir in 0 until 4) {
                val nY = curPos[0] + dy[dir]
                val nX = curPos[1] + dx[dir]

                if(nY in board.indices && nX in board[0].indices && board[nY][nX] != -1) {
                    if(board[nY][nX] == 1)
                        pq.offer(intArrayOf(nY, nX, curPos[2] + 1))
                    else
                        pq.offer(intArrayOf(nY, nX, curPos[2]))
                    board[nY][nX] = -1
                }
            }
        }
        return 0
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(arrayOf(intArrayOf(0, 1, 1, 0), intArrayOf(1, 0, 0, 1), intArrayOf(0, 1, 0, 0))))
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 1, 1, 0),
                intArrayOf(1, 1, 0, 1),
                intArrayOf(0, 0, 1, 0),
                intArrayOf(0, 1, 1, 1),
                intArrayOf(0, 1, 1, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 1, 1, 0, 1, 1),
                intArrayOf(0, 1, 1, 1, 1, 1),
                intArrayOf(1, 0, 0, 0, 1, 1),
                intArrayOf(1, 1, 0, 1, 1, 1),
                intArrayOf(1, 1, 0, 1, 1, 0),
                intArrayOf(1, 0, 0, 1, 1, 1),
                intArrayOf(1, 1, 1, 1, 1, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 1, 1, 0, 1, 1, 1),
                intArrayOf(1, 1, 1, 0, 1, 1, 1),
                intArrayOf(1, 0, 0, 0, 0, 1, 1),
                intArrayOf(1, 1, 1, 0, 1, 1, 1),
                intArrayOf(1, 1, 1, 0, 1, 1, 0),
                intArrayOf(1, 0, 1, 0, 1, 1, 1),
                intArrayOf(1, 1, 1, 1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1, 1, 1, 1),
                intArrayOf(1, 1, 1, 1, 1, 1, 0)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 0, 1, 0, 1, 1, 1),
                intArrayOf(1, 1, 0, 0, 1, 1, 1),
                intArrayOf(1, 1, 0, 1, 0, 1, 1),
                intArrayOf(0, 0, 1, 0, 1, 1, 1),
                intArrayOf(1, 0, 1, 0, 1, 1, 0),
                intArrayOf(1, 0, 1, 0, 1, 1, 1),
                intArrayOf(1, 0, 0, 1, 1, 1, 1),
                intArrayOf(1, 1, 0, 0, 1, 1, 1),
                intArrayOf(1, 1, 0, 1, 1, 1, 0)
            )
        )
    )
}