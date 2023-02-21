import java.util.Stack

data class Node(
    var isLive: Boolean = true,
    var left: Node? = null,
    var right: Node? = null,
    var originLeft: Node? = null,
    var originRight: Node? = null,
) {

}

class Solution {

    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var answer = ""


        return answer
    }
}

fun main() {
    val sol = Solution()
    println(sol.solution(8, 2, arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z")))
}