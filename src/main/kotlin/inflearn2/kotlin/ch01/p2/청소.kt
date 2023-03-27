package inflearn2.kotlin.ch01.p2

import java.util.*

class Solution {
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun solution(board: Array<IntArray>, k: Int): IntArray {
        val answer = IntArray(2)

        var dir = 0
        var curY = 0
        var curX = 0
        var time = 0

        while (time != k) {
            time++

            val nextY = curY + dy[dir]
            val nextX = curX + dx[dir]
            if (nextY == -1 || nextY == board.size ||
                nextX == -1 || nextX == board.size ||
                board[nextY][nextX] == 1
            ) {
                dir = (dir + 1) % 4
                continue
            }
            curY = nextY
            curX = nextX
        }
        answer[0] = curY
        answer[1] = curX
        return answer
    }
}

fun main() {
    val solution = Solution()
    val arr1 = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(1, 0, 1, 0, 1),
        intArrayOf(0, 0, 0, 0, 0)
    )
    println(Arrays.toString(solution.solution(arr1, 10)))

    val arr2 = arrayOf(
        intArrayOf(0, 0, 0, 1, 0, 1),
        intArrayOf(0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 1),
        intArrayOf(1, 1, 0, 0, 1, 0),
        intArrayOf(0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0)
    )
    println(Arrays.toString(solution.solution(arr2, 20)))

    val arr3 = arrayOf(
        intArrayOf(0, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 1),
        intArrayOf(0, 0, 0, 0, 0)
    )
    println(Arrays.toString(solution.solution(arr3, 25)))
}
