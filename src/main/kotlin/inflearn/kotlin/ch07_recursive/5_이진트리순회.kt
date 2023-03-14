package inflearn.kotlin.ch07_recursive

class BinaryTreeSearcher {
    var root: Node? = null

    fun preOrder(root: Node) {
        print("${root.data} ")

        root.lt?.let {
            preOrder(it)
        }

        root.rt?.let {
            preOrder(it)
        }
    }

    fun inOrder(root: Node) {
        root.lt?.let {
            inOrder(it)
        }

        print("${root.data} ")

        root.rt?.let {
            inOrder(it)
        }
    }

    fun postOrder(root: Node) {
        root.lt?.let {
            postOrder(it)
        }

        root.rt?.let {
            postOrder(it)
        }

        print("${root.data} ")
    }

    fun setRoot(n: Int) {
        root = Node(n)
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
    val tree = BinaryTreeSearcher()
    tree.setTestTree()
    with(tree.root) {
        this?.let { tree.preOrder(it) }
    }
}