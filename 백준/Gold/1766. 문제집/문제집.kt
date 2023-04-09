import java.io.*
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val problems = Array(n + 1) { mutableListOf<Int>() }
    val indegree = IntArray(n + 1)
    repeat(m) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        problems[from].add(to)
        indegree[to]++
    }

    val order = mutableListOf<Int>()
    val deque = PriorityQueue<Int>()
    for(i in 1 until indegree.size) {
        if (indegree[i] == 0)
            deque.offer(i)
    }

    while(deque.isNotEmpty()) {
        val curFrom = deque.poll()
        order.add(curFrom)
        problems[curFrom].forEach { to ->
            indegree[to]--
            if(indegree[to] == 0)
                deque.offer(to)
        }
    }

    order.forEach { print("$it ") }
}