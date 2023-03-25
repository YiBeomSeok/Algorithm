import java.io.*
import java.util.*

// 17:00
class Solution {
    val applicants = HashMap<String, MutableList<Int>>()
    lateinit var answer: IntArray
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        answer = IntArray(query.size) { 0 }

        dfs("0", 1)
        dfs("1", 1)
        dfs("2", 1)

        info.forEach {
            val st = StringTokenizer(it)
            val lang = when (st.nextToken()) {
                "cpp" -> 0
                "java" -> 1
                "python" -> 2
                else -> -1
            }
            val dev = when (st.nextToken()) {
                "backend" -> 0
                "frontend" -> 1
                else -> -1
            }
            val expert = when (st.nextToken()) {
                "junior" -> 0
                "senior" -> 1
                else -> -1
            }
            val food = when (st.nextToken()) {
                "chicken" -> 0
                "pizza" -> 1
                else -> -1
            }
            applicants["$lang$dev$expert$food"]?.add(st.nextToken().toInt())
        }

        var index = 0
        query.forEach { qr ->
            val split = qr.split(" and ", " ")
            val lang = when(split[0]) {
                "cpp" -> 0
                "java" -> 1
                "python" -> 2
                else -> "-"
            }
            val dev = when(split[1]) {
                "backend" -> 0
                "frontend" -> 1
                else -> "-"
            }
            val expert = when(split[2]) {
                "junior" -> 0
                "senior" -> 1
                else -> "-"
            }
            val food = when(split[3]) {
                "chicken" -> 0
                "pizza" -> 1
                else -> "-"
            }
            val score = split[4].toInt()

            val cmd = StringBuilder("$lang$dev$expert$food")
            dfs2(cmd, 0, score, index)
            index++
        }
        return answer
    }

    fun dfs(filter: String, depth: Int) {
        if (depth == 4) {
            applicants[filter] = mutableListOf()
        } else {
            dfs("${filter}0", depth + 1)
            dfs("${filter}1", depth + 1)
        }
    }

    fun dfs2(filter: StringBuilder, depth: Int, score: Int, index: Int) {
        if (depth == 4) {
            applicants[filter.toString()]?.forEach {
                if (it >= score)
                    answer[index]++
            }
        } else {
            if (filter[depth] == '-') {
                var next = StringBuilder(filter.toString())
                next[depth] = '0'
                dfs2(next, depth + 1, score, index)
                next[depth] = '1'
                dfs2(next, depth + 1, score, index)
                if (depth == 0) {
                    next[depth] = '2'
                    dfs2(next, 1, score, index)
                }
            } else {
                dfs2(filter, depth + 1, score, index)
            }
        }
    }
}

fun main() {
    val info = arrayOf(
        "java backend junior pizza 150",
        "python frontend senior chicken 210",
        "python frontend senior chicken 150",
        "cpp backend senior pizza 260",
        "java backend junior chicken 80",
        "python backend senior chicken 50",
    )
    val query = arrayOf(
        "java and backend and junior and pizza 100",
        "python and frontend and senior and chicken 200",
        "cpp and - and senior and pizza 250",
        "- and backend and senior and - 150",
        "- and - and - and chicken 100",
        "- and - and - and - 150"
    )
    Solution().solution(info, query)
}