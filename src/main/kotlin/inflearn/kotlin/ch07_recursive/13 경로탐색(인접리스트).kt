package inflearn.kotlin.ch07_recursive

import java.io.*
import java.util.*

class PathFinder(val n: Int, val m: Int, val graph: List<List<Int>>) {
    val ch = IntArray(n + 1) { 0 }
    var answer = 0

    init {
        ch[1] = 1
    }

    fun dfs(v: Int) {
        if(v == n) {
            answer++
        } else {
            for (nv in graph[v]) {
                if(ch[nv] == 0) {
                    ch[nv] = 1
                    dfs(nv)
                    ch[nv] = 0
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
        graph.add(ArrayList<Int>())
    }

    for(i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()

        graph[from].add(to)
    }

    val finder = PathFinder(n, m, graph)
    finder.dfs(1)
    println(finder.answer)
}

/*
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
-> 6
 */