import java.util.*

data class Edge(val to: Int, val weight: Int)

fun bfs(graph: Array<MutableList<Edge>>, visited: BooleanArray, start: Int, end: Int, weight: Int): Boolean {
    val q: Queue<Int> = LinkedList()
    q.offer(start)
    visited[start] = true
    while (q.isNotEmpty()) {
        val temp = q.poll()
        if (temp == end) return true
        for (edge in graph[temp]) {
            if (edge.weight >= weight && !visited[edge.to]) {
                visited[edge.to] = true
                q.offer(edge.to)
            }
        }
    }
    return false
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Edge>() }
    var maxWeight = 0
    repeat(m) {
        val (from, to, weight) = readLine().split(" ").map { it.toInt() }
        graph[from].add(Edge(to, weight))
        graph[to].add(Edge(from, weight))
        maxWeight = maxOf(maxWeight, weight)
    }
    val (start, end) = readLine().split(" ").map { it.toInt() }
    var left = 1
    var right = maxWeight
    var ans = 0
    while (left <= right) {
        val mid = (left + right) / 2
        val visited = BooleanArray(n + 1)
        if (bfs(graph, visited, start, end, mid)) {
            ans = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    println(ans)
}
