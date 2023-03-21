package inflearn.kotlin.ch09

import java.io.*
import java.util.*

class Edge(val vertex: Int, val cost: Int): Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return this.cost - other.cost
    }
}

fun solution(n: Int, m: Int, start: Int, graph: MutableList<MutableList<Edge>>): IntArray {
    val dis = IntArray(n + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<Edge>()
    pq.offer(Edge(start, 0))

    while(pq.isNotEmpty()) {
        val edge = pq.poll()
        val currentVertex = edge.vertex
        val currentCost = edge.cost
        if(currentCost > dis[currentVertex]) continue
        for(other in graph[currentVertex]) {
            if(dis[other.vertex] > currentCost + other.cost) {
                dis[other.vertex] = currentCost + other.cost
                pq.offer(Edge(other.vertex, currentCost + other.cost))
            }
        }
    }

    return dis
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val graph = mutableListOf<MutableList<Edge>>()
    for(i in 0 .. n) {
        graph.add(mutableListOf<Edge>())
    }


    for(i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        graph[a].add(Edge(b, c))
    }

    val ans = solution(n, m, 1, graph)
    for(i in 0 until n) {
        if(ans[i] != Int.MAX_VALUE) println("$i : ${ans[i]}")
        else println("$i : impossible")
    }
}