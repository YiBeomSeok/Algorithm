package inflearn.kotlin.ch09

import java.io.*
import java.util.*

class WonderLand(val v: Int, val e: Int, val info: Array<Edge>) {

    private val connectionState = IntArray(v + 1) { it }

    init {
        info.sort()
    }

    fun calCost(): Int {
        var answer = 0
        var count = 0 // 간선 개수는 `모든 정점 개수 - 1`개이다.
        info.forEach {
            if(count == v - 1) return answer
            val fv1 = find(it.v1)
            val fv2 = find(it.v2)
            if(fv1 != fv2) {
                answer += it.cost
                count++
                union(fv1, fv2)
            }
        }
        return answer
    }

    private fun find(v: Int): Int {
        if(connectionState[v] == v) return v
        else {
            connectionState[v] = find(connectionState[v])
            return connectionState[v]
        }
    }

    private fun union(v1: Int, v2: Int) {
        val find1 = find(v1)
        val find2 = find(v2)
        if(find1 != find2) connectionState[find1] = find2
    }

    class Edge(val v1: Int, val v2: Int, val cost: Int): Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            return this.cost - other.cost
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    st = StringTokenizer(br.readLine())
    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    val info = Array(e) {
        st = StringTokenizer(br.readLine())
        WonderLand.Edge(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
    }

    val wonderLand = WonderLand(v, e, info)

    print(wonderLand.calCost())
}