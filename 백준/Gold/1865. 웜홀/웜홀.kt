import java.io.*
import java.util.*

const val inf = 987654321

typealias P = Pair<Int, Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val tc = br.readLine().toInt()

    repeat(tc) {
        val (n, m, wf) = br.readLine().split(" ").map { it.toInt() }
        var chk = false
        val adj = MutableList(n + 2) { mutableListOf<P>() }
        val dist = IntArray(n + 1) { if (it == 1) 0 else inf }

        repeat(m) {
            val (q, w, e) = br.readLine().split(" ").map { it.toInt() }
            adj[q].add(P(w, e))
            adj[w].add(P(q, e))
        }

        repeat(wf) {
            val (q, w, e) = br.readLine().split(" ").map { it.toInt() }
            adj[q].add(P(w, -e))
        }

        for (i in 1..n) {
            var updated = false
            for (j in 1..n) {
                for (next in adj[j]) {
                    if (dist[next.first] > dist[j] + next.second) {
                        dist[next.first] = dist[j] + next.second
                        updated = true
                    }
                }
            }
            if (i == n && updated) {
                chk = true
                break
            }
        }

        if (chk) bw.write("YES\n")
        else bw.write("NO\n")
    }

    bw.flush()
    bw.close()
    br.close()

}