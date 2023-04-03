package inflearn2.kotlin.ch07.p2

class Solution {
    lateinit var visited: Array<IntArray>
    lateinit var dx: IntArray

    fun solution(pool: IntArray, a: Int, b: Int, home: Int): Int {
        visited = Array(10001) { IntArray(2) }
        dx = intArrayOf(a, -b)
        pool.forEach {
            visited[it][0] = 1 // 점프로도 못 가
            visited[it][1] = 1 // 백으로도 못 가
        }

        return bfs(home)
    }

    private fun bfs(home: Int): Int {

        val deque = ArrayDeque<IntArray>()
        var depth = 0
        deque.addLast(intArrayOf(0, 1))

        while(deque.isNotEmpty()) {

            val size = deque.size
            for(i in 0 until size) {
                val curPlace = deque.removeFirst()
                if(curPlace[0] == home) return depth

                for(dir in 0 until 2) {
                    if(dir == 1 && curPlace[1] == -1) break

                    val nextPlace = curPlace[0] + dx[dir]

                    if(dir == 0) {
                        if(nextPlace > 10000 || visited[nextPlace][0] == 1) continue
                        visited[nextPlace][0] = 1
                        deque.addLast(intArrayOf(nextPlace, 1))
                    } else {
                        if(nextPlace < 0 || visited[nextPlace][1] == 1) continue
                        visited[nextPlace][1] = 1
                        deque.addLast(intArrayOf(nextPlace, -1))
                    }
                }
            }
            depth++
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(intArrayOf(11, 7, 20), 3, 2, 10))
    println(T.solution(intArrayOf(1, 15, 11), 3, 2, 5))
    println(T.solution(intArrayOf(9, 15, 35, 30, 20), 2, 1, 25))
    println(T.solution(intArrayOf(5, 12, 7, 19, 23), 3, 5, 18))
    println(T.solution(intArrayOf(10, 15, 20), 3, 2, 2))
}