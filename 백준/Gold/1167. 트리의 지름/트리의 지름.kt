import java.io.*

val br = BufferedReader(InputStreamReader(System.`in`))

var maxDistance = 0 // 트리의 지름 길이
var farthestNode = 0 // 트리의 지름의 끝점

fun main() {
    val v = br.readLine().toInt()
    val tree = Array(v + 1) { mutableListOf<IntArray>() }

    for(i in 0 until v) {
        val split = br.readLine().split(" ")
        val node = split[0].toInt()

        var j = 1
        while(split[j].toInt() != -1) {
            val connectedNode = split[j].toInt()
            val distance = split[j + 1].toInt()
            tree[node].add(intArrayOf(connectedNode, distance))
            j += 2
        }
    }

    val visited = IntArray(v + 1)

    dfs(1, 0, tree, visited)
    dfs(farthestNode, 0, tree, visited)

    print(maxDistance)
}

fun dfs(curNode: Int, curDistance: Int, tree: Array<MutableList<IntArray>>, visited: IntArray) {
    visited[curNode] = 1

    if(curDistance > maxDistance) {
        maxDistance = curDistance
        farthestNode = curNode
    }

    for(i in 0 until tree[curNode].size) {
        if(visited[tree[curNode][i][0]] == 0) {
            dfs(tree[curNode][i][0], curDistance + tree[curNode][i][1], tree, visited)
        }
    }

    visited[curNode] = 0
}
