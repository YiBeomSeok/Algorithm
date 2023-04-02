package inflearn2.kotlin.ch06.p2

class Solution {

    lateinit var hate: Array<BooleanArray>
    lateinit var visited: BooleanArray
    var answer = 0

    fun solution(fight: Array<IntArray>): Int {

        init(fight)

        dfs(0, 0)

        return answer
    }

    private fun init(fight: Array<IntArray>) {
        hate = Array(8) { BooleanArray(8) { false } }
        visited = BooleanArray(8) { false }
        answer = 0

        fight.forEach {
            hate[it[0]][it[1]] = true
            hate[it[1]][it[0]] = true
        }
    }

    private fun dfs(prev: Int, depth: Int) {
        if (depth == 7) {
            answer++
        } else {
            for (i in 1..7) {
                if (hate[prev][i] || visited[i]) continue

                visited[i] = true
                dfs(i, depth + 1)
                visited[i] = false
            }
        }
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(arrayOf(intArrayOf(1, 3), intArrayOf(5, 7), intArrayOf(4, 2))))
    println(T.solution(arrayOf(intArrayOf(3, 2), intArrayOf(3, 5), intArrayOf(5, 2), intArrayOf(7, 3))))
    println(T.solution(arrayOf(intArrayOf(1, 2), intArrayOf(1, 5), intArrayOf(1, 7), intArrayOf(1, 3))))
    println(T.solution(arrayOf(intArrayOf(1, 7))))
    println(
        T.solution(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(5, 6),
                intArrayOf(6, 7)
            )
        )
    )
}