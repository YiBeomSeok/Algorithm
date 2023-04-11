import java.util.*

class Solution {
    data class Edge(val to: Int, val weight: Int)

    private fun dijkstra(start: Int, graph: Array<MutableList<Edge>>): IntArray {
        val n = graph.size
        val dist = IntArray(n) { Int.MAX_VALUE }
        val pq: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareBy { it.second })
        dist[start] = 0
        pq.offer(Pair(start, 0))

        while (!pq.isEmpty()) {
            val (cur, curDist) = pq.poll()
            if (dist[cur] < curDist) continue
            for (edge in graph[cur]) {
                val next = edge.to
                val nextDist = curDist + edge.weight
                if (dist[next] > nextDist) {
                    dist[next] = nextDist
                    pq.offer(Pair(next, nextDist))
                }
            }
        }
        return dist
    }

    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val graph = Array(n + 1) { mutableListOf<Edge>() }
        for (fare in fares) {
            val (from, to, weight) = fare
            graph[from].add(Edge(to, weight))
            graph[to].add(Edge(from, weight))
        }

        val distFromS = dijkstra(s, graph)
        val distFromA = dijkstra(a, graph)
        val distFromB = dijkstra(b, graph)

        var answer = Int.MAX_VALUE
        for (i in 1..n) {
            answer = minOf(answer, distFromS[i] + distFromA[i] + distFromB[i])
        }
        return answer
    }
}