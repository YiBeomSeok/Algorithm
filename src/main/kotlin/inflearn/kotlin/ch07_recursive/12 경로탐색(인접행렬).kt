package inflearn.kotlin.ch07_recursive

import java.io.*

class Pathfinder(val n: Int, val m: Int, val graph: Array<IntArray>) {

    val ch = IntArray(n + 1) { 0 }
    var answer: Int = 0

    init {
        ch[1] = 1
    }

    fun dfs(v: Int) {
        if(v == n) {
            answer++
        } else {
            for (i in 1 .. n) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1
                    dfs(i)
                    ch[i] = 0
                }
            }
        }
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    var split = reader.readLine().split(" ")

    val n = split[0].toInt()
    val m = split[1].toInt()

    val graph = Array(n + 1) { IntArray(n + 1) { 0 } }
    for (i in 0 until m) {
        split = reader.readLine().split(" ")
        graph[split[0].toInt()][split[1].toInt()] = 1
    }

    val finder = Pathfinder(n, m, graph)

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