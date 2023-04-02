package inflearn2.kotlin.ch06.p1

class Solution {

    private lateinit var candidateNumbers: IntArray
    private lateinit var visited: BooleanArray
    private var answer = -1

    fun solution(n: Int): Int {
        init(n)
        dfs(0, n, 0)
        return answer
    }

    private fun init(n: Int) {
        candidateNumbers = n.toString().toCharArray().map { it - '0' }.sorted().toIntArray()
        visited = BooleanArray(candidateNumbers.size) { false }
        answer = -1
    }

    private fun dfs(currentNumber: Int, targetNumber: Int, depth: Int) {
        if(answer != -1) return

        if (currentNumber > targetNumber) {
            answer = currentNumber
            return
        }

        candidateNumbers.forEachIndexed { index, num ->
            if (!visited[index]) {
                visited[index] = true
                dfs(currentNumber * 10 + num, targetNumber, depth + 1)
                visited[index] = false
            }
        }
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(123))
    println(T.solution(321))
    println(T.solution(20573))
    println(T.solution(27711))
    println(T.solution(54312))
}