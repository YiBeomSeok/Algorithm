import java.io.*
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

class Node(
    var data: Int,
    var left: Node? = null,
    var right: Node? = null,
)

class Solution(
    val n: Int,
    val inOrder: IntArray,
    val postOrder: IntArray,
) {
    fun solution(): Node? {
        return makeTree(inOrder, postOrder, 0, n - 1, 0, n - 1)
    }

    private fun makeTree(inOrder: IntArray, postOrder: IntArray, inOrderStart: Int, inOrderEnd: Int, postOrderStart: Int, postOrderEnd: Int): Node? {
        if (inOrderStart > inOrderEnd) return null
        if (inOrderStart == inOrderEnd) return Node(data = inOrder[inOrderStart])

        val rootNodeNumber = postOrder[postOrderEnd]
        val rootNode = Node(data = rootNodeNumber)

        var turn = inOrderStart
        for (i in inOrderStart..inOrderEnd) {
            if (inOrder[i] == rootNodeNumber) break
            turn++
        }

        rootNode.left = makeTree(inOrder, postOrder, inOrderStart, turn - 1, postOrderStart, postOrderStart + turn - inOrderStart - 1)
        rootNode.right = makeTree(inOrder, postOrder, turn + 1, inOrderEnd, postOrderStart + turn - inOrderStart, postOrderEnd - 1)

        return rootNode
    }
}

fun main() {
    val n = br.readLine().toInt()

    var st = StringTokenizer(br.readLine())
    val inOrder = IntArray(n) {
        st.nextToken().toInt()
    }

    st = StringTokenizer(br.readLine())
    val postOrder = IntArray(n) {
        st.nextToken().toInt()
    }

    val sol = Solution(n, inOrder, postOrder)

    val root = sol.solution()

    preOrder(root!!)
}

fun preOrder(root: Node) {
    print("${root.data} ")

    root.left?.let { preOrder(it) }
    root.right?.let { preOrder(it) }
}