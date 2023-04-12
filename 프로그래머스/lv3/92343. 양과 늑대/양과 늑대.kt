class Solution {
    private var answer: Int = 0

    fun solution(info: IntArray, edges: Array<IntArray>): Int {

        val graph = Array(info.size) { mutableListOf<Int>() }

        for(edge in edges) {
            graph[edge[0]].add(edge[1])
        }

        val next = mutableListOf<Int>()
        next.add(0)

        dfs(info, graph, next, 0, 0, 0)

        return answer
    }

    private fun dfs(info: IntArray, graph: Array<MutableList<Int>>, curList: MutableList<Int>, node: Int, sheep: Int, wolf: Int) {
        var curSheep = sheep
        var curWolf = wolf

        if(info[node] == 0) {
            curSheep += 1
        } else {
            curWolf += 1
        }

        if(curSheep <= curWolf) {
            return
        }

        answer = maxOf(answer, curSheep)

        val next = mutableListOf<Int>()
        next.addAll(curList)
        if(graph[node].isNotEmpty()) {
            next.addAll(graph[node])
        }
        next.remove(node)

        next.forEach {
            dfs(info, graph, next, it, curSheep, curWolf)
        }
    }
}