package inflearn2.kotlin.ch01.p7

class Solution {
    val dx = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
    val dy = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)

    fun solution(keypad: IntArray, password: String): Int {
        val dist = Array(10) { IntArray(10) { 2 } }
        val board = Array(10) { IntArray(10) }

        keypad.forEachIndexed { i, num ->
            board[i / 3][i % 3] = num
        }

        for(i in board.indices) {
            for(j in board[i].indices) {
                for(dir in 0 until 8) {
                    val nY = i + dy[dir]
                    val nX = j + dx[dir]

                    if (nY in board.indices && nX in board.indices) {
                        dist[board[i][j]][board[nY][nX]] = 1
                    }
                }
            }
        }

        var answer = 0

        var prevNum = password[0] - '0'
        for(i in 1 until password.length) {
            answer += dist[prevNum][password[i] - '0']
            prevNum = password[i] - '0'
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(intArrayOf(2, 5, 3, 7, 1, 6, 4, 9, 8), "7596218"))
    println(T.solution(intArrayOf(1, 5, 7, 3, 2, 8, 9, 4, 6), "63855526592"))
    println(T.solution(intArrayOf(2, 9, 3, 7, 8, 6, 4, 5, 1), "323254677"))
    println(T.solution(intArrayOf(1, 6, 7, 3, 8, 9, 4, 5, 2), "3337772122"))
}