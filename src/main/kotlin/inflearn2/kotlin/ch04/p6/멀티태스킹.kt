package inflearn2.kotlin.ch04.p6

class Solution {
    fun solution(tasks: IntArray, k: Long): Int {
        var answer = 0

        val sortedTasks = tasks.copyOf(tasks.size + 1).apply { sort() }
        var rest = tasks.size

        var totalTime = k

        for (i in 1 until sortedTasks.size) {
            val time = rest * (sortedTasks[i] - sortedTasks[i - 1])
            if (totalTime < time) {
                val idx = totalTime % rest
                var cnt = 0L
                for (j in tasks.indices) {
                    if (tasks[j] >= sortedTasks[i]) {
                        if (cnt == idx) return j + 1
                        cnt++
                    }
                }
            } else {
                totalTime -= time
                rest--
            }
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(intArrayOf(1, 2, 3), 5))
    println(T.solution(intArrayOf(8, 5, 2, 9, 10, 7), 30))
    println(T.solution(intArrayOf(8, 9, 12, 23, 45, 16, 25, 50), 100))
}
