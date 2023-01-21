package programmers.kakao2019blindrecruitment.wayfinding_game

class Solution42892 {

    inner class Node(
        var number: Int,
        var x: Int,
        var y: Int,
        var left: Node?,
        var right: Node?
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return if (this.y == other.y) {
                this.x - other.x
            } else other.y - this.y
        }
    }


    private lateinit var answer: Array<Array<Int>>
    private var idx: Int = 0

    fun solution(nodeinfo: Array<IntArray>): Array<Array<Int>> {
        answer = Array(2) { Array(nodeinfo.size) { 0 } }
        val list = arrayListOf<Node>()

        for (i in nodeinfo.indices) {
            list.add(Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null))
        }
        list.sort()

        val root = list[0]
        for (i in 1 until list.size) {
            insertNode(root, list[i])
        }

        preorder(root)
        idx = 0
        postorder(root)

        return answer
    }

    private fun insertNode(parent: Node?, child: Node?) {
        require(parent != null)
        require(child != null)

        if (parent.x > child.x) {
            if (parent.left == null)
                parent.left = child
            else
                insertNode(parent.left, child)
        } else
            if (parent.right == null)
                parent.right = child
            else
                insertNode(parent.right, child)
    }

    private fun preorder(root: Node?) {
        if (root != null) {
            answer[0][idx++] = root.number
            preorder(root.left)
            preorder(root.right)
        }
    }

    private fun postorder(root: Node?) {
        if (root != null) {
            postorder(root.left)
            postorder(root.right)
            answer[1][idx++] = root.number
        }
    }
}