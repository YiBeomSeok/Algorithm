package inflearn2.kotlin.ch01.p4

import java.util.*

class Solution {
    fun solution(c: Int, r: Int, k: Int): IntArray {
        val answer = IntArray(2)
        if (k > c * r) return intArrayOf(0, 0)
        val seat = Array(c) { IntArray(r) }
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, 1, 0, -1)
        var x = 0
        var y = 0
        var count = 1
        var d = 1
        while (count < k) {
            val nx = x + dx[d]
            val ny = y + dy[d]
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] > 0) {
                d = (d + 1) % 4
                continue
            }
            seat[x][y] = count
            count++
            x = nx
            y = ny
        }
        answer[0] = x + 1
        answer[1] = y + 1
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