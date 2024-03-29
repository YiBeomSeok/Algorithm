package inflearn2.kotlin.ch08.p1

class Solution {
    var answer = Int.MAX_VALUE

    fun solution(n: Int, flights: Array<IntArray>, s: Int, e: Int, k: Int): Int {
        answer = Int.MAX_VALUE
        val graph = Array(n) { mutableListOf<IntArray>() }
        flights.forEach {
            graph[it[0]].add(intArrayOf(it[1], it[2]))
        }

        dfs(0, -1, s, e, k, graph)

        return if(answer == Int.MAX_VALUE) -1 else answer
    }

    private fun dfs(sumCost: Int, depth: Int, s: Int, e: Int, k: Int, graph: Array<MutableList<IntArray>>) {
        if(sumCost > answer) return

        if(depth <= k && s == e) {
            answer = minOf(answer, sumCost)
        } else {
            graph[s].forEach {
                dfs(sumCost + it[1], depth + 1, it[0], e, k, graph)
            }
        }
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            5,
            arrayOf(
                intArrayOf(0, 1, 10),
                intArrayOf(1, 2, 20),
                intArrayOf(0, 2, 70),
                intArrayOf(0, 3, 100),
                intArrayOf(1, 3, 80),
                intArrayOf(2, 3, 10),
                intArrayOf(2, 4, 30),
                intArrayOf(3, 4, 10)
            ),
            0,
            3,
            1
        )
    )
    println(
        T.solution(
            4,
            arrayOf(intArrayOf(0, 1, 10), intArrayOf(0, 2, 10), intArrayOf(1, 3, 5), intArrayOf(2, 3, 3)),
            0,
            3,
            0
        )
    )
    println(
        T.solution(
            8,
            arrayOf(
                intArrayOf(0, 3, 10),
                intArrayOf(1, 5, 10),
                intArrayOf(1, 7, 100),
                intArrayOf(0, 1, 10),
                intArrayOf(0, 2, 10),
                intArrayOf(5, 7, 30),
                intArrayOf(3, 7, 10),
                intArrayOf(1, 3, 5),
                intArrayOf(2, 3, 3)
            ),
            1,
            7,
            2
        )
    )
    println(
        T.solution(
            10,
            arrayOf(
                intArrayOf(1, 8, 50),
                intArrayOf(0, 8, 30),
                intArrayOf(1, 0, 10),
                intArrayOf(2, 8, 10),
                intArrayOf(0, 3, 10),
                intArrayOf(1, 5, 10),
                intArrayOf(1, 7, 100),
                intArrayOf(0, 1, 10),
                intArrayOf(0, 2, 10),
                intArrayOf(5, 7, 30),
                intArrayOf(3, 7, 10),
                intArrayOf(1, 3, 5),
                intArrayOf(2, 3, 3)
            ),
            1,
            8,
            2
        )
    )
}