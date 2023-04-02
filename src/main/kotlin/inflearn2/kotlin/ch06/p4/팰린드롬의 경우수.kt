package inflearn2.kotlin.ch06.p4

import java.util.*
import kotlin.collections.HashSet

class Solution {

    lateinit var chCounts: HashMap<Char, Int>
    lateinit var answer: MutableList<String>
    var chMid = ""

    fun solution(s: String): Array<String> {

        init()

        s.forEach {
            chCounts[it] = chCounts.getOrDefault(it, 0) + 1
        }

        val characters = mutableListOf<Char>()
        chCounts.forEach {
            if(it.value % 2 == 1) {
                if(chMid != "") return arrayOf()
                chMid = "${it.key}"
            }

            for(i in 0 until it.value / 2) {
                characters.add(it.key)
            }
        }

        val visited = HashSet<String>()
        val used = HashMap<Char, Int>()
        val sb = StringBuilder()
        dfs(sb, characters, visited, used, 0)

        return answer.toTypedArray()
    }

    private fun init() {
        chCounts = HashMap<Char, Int>()
        answer = mutableListOf()
        chMid = ""
    }

    private fun dfs(str: StringBuilder, characters: MutableList<Char>, visited: HashSet<String>, used: HashMap<Char, Int>, depth: Int) {
        if(depth == characters.size) {
            val res = str.toString()
            answer.add("$res$chMid${res.reversed()}")
        } else {
            for(i in 0 until characters.size) {
                if(used[characters[i]] == chCounts[characters[i]]!! / 2) continue

                str.append(characters[i])

                val next = str.toString()
                if(visited.contains(next)) {
                    str.deleteAt(str.length - 1)
                    continue
                }

                visited.add(next)
                val tmp = used.getOrDefault(characters[i], 0)
                used[characters[i]] = tmp + 1
                dfs(str, characters, visited, used, depth + 1)
                str.deleteAt(str.length - 1)
                used[characters[i]] = tmp
            }
        }
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(Arrays.toString(T.solution("aaaabb")))
    println(Arrays.toString(T.solution("abbcc")))
    println(Arrays.toString(T.solution("abbccee")))
    println(Arrays.toString(T.solution("abbcceee")))
    println(Arrays.toString(T.solution("ffeffaae")))
}