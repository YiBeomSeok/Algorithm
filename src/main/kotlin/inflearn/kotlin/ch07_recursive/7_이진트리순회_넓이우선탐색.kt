package inflearn.kotlin.ch07_recursive

class BinaryTreeSearcherBFS {
    var root: Node? = null

    fun bfs(root: Node) {
        val queue = ArrayDeque<Node>()
        queue.add(root)
        var LEVEL = 0
        while (queue.isNotEmpty()) {
            val len = queue.size
            print("$LEVEL : ")
            for (i in 0 until len) {
                val cur = queue.removeFirst()
                print("${cur.data} ")

                cur.lt?.let { queue.add(it) }
                cur.rt?.let { queue.add(it) }
            }
            LEVEL++
            println()
        }
    }

    fun setTestTree() {
        root = Node(1)
        root?.lt = Node(2)
        root?.rt = Node(3)
        root?.lt?.lt = Node(4)
        root?.lt?.rt = Node(5)
        root?.rt?.lt = Node(6)
        root?.rt?.rt = Node(7)
    }

    data class Node(
        val data: Int,
        var lt: Node? = null,
        var rt: Node? = null,
    )
}

fun main() {
    val tree = BinaryTreeSearcherBFS()
    tree.setTestTree()
    tree.root?.let { tree.bfs(it) }
}