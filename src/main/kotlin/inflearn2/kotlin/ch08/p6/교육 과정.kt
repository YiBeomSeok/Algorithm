package inflearn2.kotlin.ch08.p6

import java.util.PriorityQueue

class Solution {
    fun solution(
        subjects: Array<String>,
        course: Array<String>
    ): Array<String> {
        val n = subjects.size
        val node = HashMap<String, Int>()
        subjects.forEachIndexed { i, s ->
            node[s] = i
        }
        val graph = Array(n) { mutableListOf<Int>() }
        val indegree = IntArray(n)

        course.forEach {
            with(it.split(" ")) {
                val from = node[this[1]]!!
                val to = node[this[0]]!!

                graph[from].add(to)
                indegree[to]++
            }
        }

        val order = mutableListOf<Int>()
        val queue = ArrayDeque<Int>()
        indegree.forEachIndexed { i, v -> if (v == 0) queue.addLast(i) }

        while (queue.isNotEmpty()) {
            val curFrom = queue.removeFirst()
            order.add(curFrom)
            graph[curFrom].forEach { to ->
                indegree[to]--
                if (indegree[to] == 0) {
                    queue.addLast(to)
                }
            }
        }

        val answer = Array(n) {
            subjects[order[it]]
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf("english", "math", "physics", "art", "music"),
            arrayOf("art math", "physics art", "art music", "physics math", "english physics")
        ).joinToString()
    )
    println(
        T.solution(
            arrayOf("art", "economics", "history", "chemistry"),
            arrayOf("chemistry history", "economics history", "art economics")
        ).joinToString()
    )
    println(
        T.solution(
            arrayOf("math", "science", "music", "biology"),
            arrayOf("science music", "math music", "math science", "biology math")
        ).joinToString()
    )
}