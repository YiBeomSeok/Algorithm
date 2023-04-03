package inflearn2.kotlin.ch07.p3

class Solution {
    lateinit var visited: Array<IntArray>

    fun solution(s: Int, e: Int): Int {
        visited = Array(2) { IntArray(200001) }

        return bfs(s, e)
    }

    private fun bfs(s: Int, e: Int): Int {
        val deque = ArrayDeque<Int>()
        var cow = e
        deque.addLast(s)
        visited[0][s] = 1

        var depth = 0
        while (deque.isNotEmpty()) {
            val len = deque.size
            depth++

            for (i in 0 until len) {
                val curX = deque.removeFirst()
                for (nextX in intArrayOf(curX - 1, curX + 1, curX * 2)) {
                    if (nextX in 0..200000 && visited[depth % 2][nextX] == 0) {
                        visited[depth % 2][nextX] = 1
                        deque.addLast(nextX)
                    }
                }
            }
            cow += depth
            if (cow > 200000) return -1
            if (visited[depth % 2][cow] == 1) return depth
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(1, 11))
    println(T.solution(10, 3))
    println(T.solution(1, 34567))
    println(T.solution(5, 6))
    println(T.solution(2, 54321))
}