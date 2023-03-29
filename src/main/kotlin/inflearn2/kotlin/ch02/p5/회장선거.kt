package inflearn2.kotlin.ch02.p5

import java.util.*

class Solution {
    fun solution(votes: Array<String>, k: Int): String {
        val candidates = HashMap<String, MutableList<String>>()
        val persons = TreeMap<String, Int>()

        for(i in votes.indices) {
            val st = StringTokenizer(votes[i])
            val from = st.nextToken()
            val to = st.nextToken()

            candidates[to] = candidates.getOrDefault(to, mutableListOf()).apply {
                this.add(from)
            }
        }

        var maxGiftCount = 0
        for(candidate in candidates) {
            if(candidate.value.size >= k) {
                for(voter in candidate.value) {
                    val giftCount = persons.getOrDefault(voter, 0) + 1
                    persons[voter] = giftCount
                    maxGiftCount = maxOf(maxGiftCount, giftCount)
                }
            }
        }

        var answer = " "
        persons.forEach {
            if(it.value == maxGiftCount) return it.key
        }
        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf("john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"),
            2
        )
    )
    println(
        T.solution(
            arrayOf(
                "john tom",
                "park luis",
                "john luis",
                "luis tom",
                "park tom",
                "luis john",
                "luis park",
                "park john",
                "john park",
                "tom john",
                "tom park",
                "tom luis"
            ), 2
        )
    )
    println(
        T.solution(
            arrayOf(
                "cody tom",
                "john tom",
                "cody luis",
                "daniel luis",
                "john luis",
                "luis tom",
                "daniel tom",
                "luis john"
            ), 2
        )
    )
    println(
        T.solution(
            arrayOf(
                "bob tom",
                "bob park",
                "park bob",
                "luis park",
                "daniel luis",
                "luis bob",
                "park luis",
                "tom bob",
                "tom luis",
                "john park",
                "park john"
            ), 3
        )
    )
}