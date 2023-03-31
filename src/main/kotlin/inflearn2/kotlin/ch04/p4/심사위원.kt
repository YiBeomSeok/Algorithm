package inflearn2.kotlin.ch04.p4

class Solution {
    fun solution(score: IntArray, k: Int): Int {

        score.sort()

        for(i in 0 ..score.size - k) {
            if(score[i + k - 1] - score[i] <= 10)
                return getAvg(score, i, i + k - 1, k)
        }

        return 0
    }

    private fun getAvg(score: IntArray, first: Int, last: Int, k: Int): Int {
        var sum = 0
        for(i in first .. last) {
            sum += score[i]
        }
        return sum / k
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(intArrayOf(99, 97, 80, 91, 85, 95, 92), 3))
    println(T.solution(intArrayOf(92, 90, 77, 91, 70, 83, 89, 76, 95, 92), 4))
    println(T.solution(intArrayOf(77, 88, 78, 80, 78, 99, 98, 92, 93, 89), 5))
    println(T.solution(intArrayOf(88, 99, 91, 89, 90, 72, 75, 94, 95, 100), 5))
}