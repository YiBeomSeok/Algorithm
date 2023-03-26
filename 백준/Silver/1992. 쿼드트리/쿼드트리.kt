import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun dfs(r: Int, c: Int, n: Int, graph: Array<String>) {
    val ch = graph[r][c]
    var finish = true
    
    for (i in r until r + n) {
        for (j in c until c + n) {
            if (ch != graph[i][j]) {
                finish = false
                break
            }
        }
        if (!finish) break
    }
    
    if (!finish) {
        bw.write("(")
        dfs(r, c, n / 2, graph)
        dfs(r, c + n / 2, n / 2, graph)
        dfs(r + n / 2, c, n / 2, graph)
        dfs(r + n / 2, c + n / 2, n / 2, graph)
        bw.write(")")
    } else {
        bw.write(ch.toString())
    }
}

fun main() {
    val n = br.readLine().toInt()
    val graph = Array(n) { br.readLine() }
    dfs(0, 0, n, graph)
    bw.flush()
}
