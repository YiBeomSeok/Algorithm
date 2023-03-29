package inflearn2.kotlin.ch01.p7

import java.util.*

class Point(val y: Int, val x: Int, var weight: Int): Comparable<Point> {
    override fun compareTo(other: Point) = this.weight - other.weight
}
class Solution {
    val dx = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
    val dy = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)

    fun solution(keypad: IntArray, password: String): Int {
        val check = Array(10) { IntArray(10) { Int.MAX_VALUE } }

        val board = Array(4) { IntArray(4) }
        var offset = 0
        for(i in 1 .. 3) {
            for(j in 1 .. 3) {
                board[i][j] = keypad[offset++]
            }
        }

        for(i in 1 .. 3) {
            for(j in 1 ..3) {
                val curNumber = board[i][j]

                bfs(curNumber, i, j, board, check)
            }
        }

        var answer = 0
        var prev = password[0] - '0'
        for(i in 1 until password.length) {
            val cur = password[i] - '0'
            answer += check[prev][cur]
            prev = cur
        }

        return answer
    }

    fun bfs(curNumber: Int, curY: Int, curX: Int, board: Array<IntArray>, check: Array<IntArray>) {
        check[curNumber][curNumber] = 0

        val pq = PriorityQueue<Point>()
        pq.add(Point(curY, curX, 0))

        while(pq.isNotEmpty()) {
            val curPoint = pq.poll()

            if(curPoint.weight > check[curNumber][board[curPoint.y][curPoint.x]]) continue

            for(dir in 0 until 8) {
                val nextY = curPoint.y + dy[dir]
                val nextX = curPoint.x + dx[dir]

                if(nextY == 0 || nextY == 4 ||
                    nextX == 0 || nextX == 4) continue

                if(curPoint.weight + 1 < check[curNumber][board[nextY][nextX]]) {
                    check[curNumber][board[nextY][nextX]] = curPoint.weight + 1
                    pq.add(Point(nextY, nextX, curPoint.weight + 1))
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(intArrayOf(2, 5, 3, 7, 1, 6, 4, 9, 8), "7596218"))
    println(T.solution(intArrayOf(1, 5, 7, 3, 2, 8, 9, 4, 6), "63855526592"))
    println(T.solution(intArrayOf(2, 9, 3, 7, 8, 6, 4, 5, 1), "323254677"))
    println(T.solution(intArrayOf(1, 6, 7, 3, 8, 9, 4, 5, 2), "3337772122"))
}