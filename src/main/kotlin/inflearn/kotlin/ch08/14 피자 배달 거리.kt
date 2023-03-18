package inflearn.kotlin.ch08

import java.io.*
import java.util.*
import kotlin.math.abs

// 2:00 -> 3:22 120분

class Solution(val n: Int, val m: Int, val board: Array<IntArray>) {

    var minDistance = Int.MAX_VALUE
    val homes = ArrayList<Point>()
    val stores = ArrayList<Point>()
    lateinit var combi: Array<Point>

    fun solution(): Int {
        for(i in 1 .. n) {
            for(j in 1 .. n) {
                if(board[i][j] == 1) {
                    homes.add(Point(i, j))
                } else if(board[i][j] == 2) {
                    stores.add(Point(i, j))
                }
            }
        }

        combi = Array(m) { Point(0, 0) }

        dfs(0, 0)

        return minDistance
    }

    private fun dfs(depth: Int, start: Int) {
        if(depth == m) {
            var minPizzaDeliveryDistance = 0
            for(home in homes) {
                var minDistance = Int.MAX_VALUE
                for(store in combi) {
                    minDistance = minOf(minDistance, abs(store.y - home.y) + abs(store.x - home.x))
                }
                minPizzaDeliveryDistance += minDistance
            }
            minDistance = minOf(minPizzaDeliveryDistance, minDistance)
        } else {
            for(i in start until stores.size) {
                combi[depth] = stores[i]
                dfs(depth + 1, i + 1)
            }
        }
    }

    class Point(val y: Int, val x: Int)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val board = Array(n + 1) { IntArray(n + 1) }
    for(i in 1 .. n) {
        st = StringTokenizer(br.readLine())
        for(j in 1 .. n) {
            board[i][j] = st.nextToken().toInt()
        }
    }

    val sol = Solution(n, m, board)
    println(sol.solution())
}