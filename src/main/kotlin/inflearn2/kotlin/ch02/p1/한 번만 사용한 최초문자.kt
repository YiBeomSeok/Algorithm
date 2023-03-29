package inflearn2.kotlin.ch02.p1

class Solution {
    fun solution(s: String): Int {
        val map = LinkedHashMap<Char, Int>()

        for(ch in s) {
            map[ch] = map.getOrDefault(ch, 0) + 1
        }

        map.forEach {
            if(it.value == 1) return s.indexOf(it.key) + 1
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution("statitsics"))
    println(T.solution("aabb"))
    println(T.solution("stringshowtime"))
    println(T.solution("abcdeabcdfg"))
}