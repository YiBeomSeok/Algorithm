package inflearn2.kotlin.ch01.p4

import java.util.*

class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)


    fun solution(c: Int, r: Int, k: Int): IntArray {
        var dir = 0
        val answer = IntArray(2)
        val visited = Array(r + 2) {
            IntArray(c + 2)
        }

        visited[r + 1][1] = 1
        visited[r][c + 1] = 1
        visited[0][c] = 1

        visited[1][1] = 1
        var x = 1
        var y = 1
        var number = 1

        while(number < k) {
            number++

            var nextX = x + dx[dir]
            var nextY = y + dy[dir]
            if(visited[nextY][nextX] == 1) {
                dir = (dir + 1) % 4
                nextX = x + dx[dir]
                nextY = y + dy[dir]
            }

            if(visited[nextY][nextX] == 1) return intArrayOf(0, 0)
            visited[nextY][nextX] = 1
            x = nextX
            y = nextY
        }

        answer[0] = x
        answer[1] = y
        return answer
    }
}

fun main() {
    val T = Solution()
    println(Arrays.toString(T.solution(6, 5, 12)))
    println(Arrays.toString(T.solution(6, 5, 20)))
    println(Arrays.toString(T.solution(6, 5, 30)))
    println(Arrays.toString(T.solution(6, 5, 31)))
}