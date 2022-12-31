package programmers.kakao2022techintern

class Solution118667 {
    fun solution(queue1: IntArray, queue2: IntArray): Long {
        val qu1 = toArrayDeque(queue1)
        val qu2 = toArrayDeque(queue2)
        var sum1: Long = qu1.sum()
        var sum2: Long = qu2.sum()
        val standard = (sum1 + sum2) / 2
        if (((sum1 + sum2) % 2).toInt() != 0)
            return -1
        var count: Long = 0
        val limit = queue1.count() * 4

        while (count < limit) {
            if (sum1 == sum2)
                return count
            count++
            if (sum1 < sum2) {
                val remove = qu2.removeFirst()
                qu1.addLast(remove)
                sum2 -= remove
                sum1 += remove
            } else {
                val remove = qu1.removeFirst()
                qu2.addLast(remove)
                sum1 -= remove
                sum2 += remove
            }
        }

        return -1
    }

    private fun toArrayDeque(queue: IntArray): ArrayDeque<Long> {
        val result = ArrayDeque<Long>()
        for (elem in queue) result.addLast(elem.toLong())
        return result
    }
}

fun main() {
    val s = Solution118667()
    println(
        s.solution(
            intArrayOf(3, 2, 7, 2), intArrayOf(4, 6, 5, 1)
        )
    )
    println(
        s.solution(
            intArrayOf(1, 2, 1, 2), intArrayOf(1, 10, 1, 2)
        )
    )
    println(
        s.solution(
            intArrayOf(1, 1), intArrayOf(1, 5)
        )
    )
}