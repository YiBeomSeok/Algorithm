package inflearn.kotlin.ch07_recursive

fun BinaryTreeSearcher.initTestSet() {
    this.root = BinaryTreeSearcher.Node(1)
    this.root?.lt = BinaryTreeSearcher.Node(2)
    this.root?.rt = BinaryTreeSearcher.Node(3)
    this.root?.lt?.lt = BinaryTreeSearcher.Node(4)
    this.root?.lt?.rt = BinaryTreeSearcher.Node(5)
}

fun BinaryTreeSearcher.dfs(depth: Int, root: BinaryTreeSearcher.Node?): Int {

    if (root == null || (root.lt == null && root.rt == null))
        return depth
    else return Math.min(dfs(depth + 1, root.lt), dfs(depth + 1, root.rt))
}

fun main() {
    val tree = BinaryTreeSearcher().apply { this.initTestSet() }
    print(tree.dfs(0, tree.root))
}