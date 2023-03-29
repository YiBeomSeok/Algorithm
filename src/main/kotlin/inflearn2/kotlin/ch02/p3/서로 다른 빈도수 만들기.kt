package inflearn2.kotlin.ch02.p3

class Solution {
    fun solution(s: String): Int {
        var answer = 0

        val hashMap = HashMap<Char, Int>()

        s.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }

        val hashSet = HashSet<Int>()
        hashMap.forEach {
            var curValue = it.value

            while(hashSet.contains(curValue)) {
                curValue--
                answer++
            }

            if(curValue != 0) {
                hashSet.add(curValue)
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution("aaabbbcc"))
    println(T.solution("aaabbc"))
    println(T.solution("aebbbbc"))
    println(T.solution("aaabbbcccde"))
    println(T.solution("aaabbbcccdddeeeeeff"))
}