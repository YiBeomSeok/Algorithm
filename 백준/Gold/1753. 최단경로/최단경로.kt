import java.io.*
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

class Edge(val to: Int, val weight: Int)

class Solution(
    val v: Int,
    val e: Int,
    val k: Int,
    val graph: Array<MutableList<Edge>>,
) {
    fun solution(): IntArray {

        val check = IntArray(v + 1) { Int.MAX_VALUE }
        check[k] = 0

        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.add(Pair(k, 0))
        while(pq.isNotEmpty()) {
            val curNode = pq.poll()

            if(check[curNode.first] < curNode.second) continue
            
            for(edge in graph[curNode.first]) {
                if(check[edge.to] > check[curNode.first] + edge.weight) {
                    check[edge.to] = check[curNode.first] + edge.weight
                    pq.add(Pair(edge.to, check[edge.to]))
                }
            }
        }

        return check
    }
}
fun main() {
    var st = StringTokenizer(br.readLine())

    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    val k = br.readLine().toInt()

    val graph = Array(v + 1) { mutableListOf<Edge>() }
    for(i in 0 until e) {
        st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val weight = st.nextToken().toInt()

        graph[from].add(Edge(to, weight))
    }

    val sol = Solution(v, e, k, graph)
    val answer = sol.solution()

    for(i in 1 .. v) {
        val elem = answer[i]
        if(elem == Int.MAX_VALUE) println("INF")
        else {
            println(elem)
        }
    }
}