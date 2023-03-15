package inflearn.kotlin.ch07_recursive

import java.io.*
import java.util.*

class PathFinderBFS(val n: Int, val m: Int, val graph: List<List<Int>>) {
    val ch = IntArray(n + 1) { 0 }
    val dist = IntArray(n + 1) { 0 }

    init {
        ch[1] = 1
    }

    fun bfs(v: Int) {
        val deque = ArrayDeque<Int>()
        ch[v] = 1
        dist[v] = 0
        deque.addLast(v)

        while(deque.isNotEmpty()) {
            val cv = deque.removeFirst()
            for(nv in graph[cv]) {
                if(ch[nv] == 0) {
                    ch[nv] = 1
                    deque.addLast(nv)
                    dist[nv] = dist[cv] + 1
                }
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val graph = ArrayList<ArrayList<Int>>(n + 1)
    for(i in 0 .. n) {
        graph.add(ArrayList())
    }

    for(i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        graph[from].add(to)
    }

    val finder = PathFinderBFS(n, m, graph)
    finder.bfs(1)

    for(i in 2 .. n) {
        println("$i : ${finder.dist[i]}")
    }
}

/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

->
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
 */