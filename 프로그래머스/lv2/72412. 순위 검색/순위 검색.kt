import java.util.*

class Solution {

    private lateinit var infos: MutableMap<String, MutableList<Int>>

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer = IntArray(query.size)

        initInfos(info)

        val queryLen = query.size
        for(i in 0 until queryLen) {
            val st = StringTokenizer(query[i])
            var cmd = ""

            for(j in 0 until 8) {
                val str = st.nextToken()
                if(j % 2 == 0)
                    cmd += str
                else if (j == 7) {
                    if(infos[cmd] == null) {
                        answer[i] = 0
                    } else {
                        answer[i] = binarySearch(infos[cmd]!!, str.toInt())
                    }
                }
            }
        }

        return answer
    }

    private fun binarySearch(infoFinding: MutableList<Int>, targetScore: Int): Int {
        val size = infoFinding.size

        var left = 0
        var right = size - 1

        while(left <= right) {
            val mid = (right + left) / 2

            if(infoFinding[mid] < targetScore) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return size - left
    }

    private fun initInfos(info: Array<String>) {
        infos = mutableMapOf()

        for(element in info) {
            val st = StringTokenizer(element)
            val word = Array<Array<String>>(4) { Array<String>(2) { "-" } }
            for(i in 0 until 4) {
                word[i][0] = st.nextToken()
            }
            val score = st.nextToken().toInt()

            dfsForInitInfos("", word, score, 0)
        }

        infos.forEach {
            it.value.sort()
        }
    }

    private fun dfsForInitInfos(curInfo: String, word: Array<Array<String>>, score: Int, depth: Int) {
        if(depth == 4) {
            if(infos.contains(curInfo)) {
                infos[curInfo]!!.add(score)
            } else {
                infos[curInfo] = mutableListOf()
                infos[curInfo]!!.add(score)
            }
        } else {
            dfsForInitInfos(curInfo + word[depth][0], word, score, depth + 1)
            dfsForInitInfos(curInfo + word[depth][1], word, score, depth + 1)
        }
    }
}