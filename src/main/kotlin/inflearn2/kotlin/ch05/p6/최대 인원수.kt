package inflearn2.kotlin.ch05.p6

class Solution {
    fun solution(n: Int, trans: Array<IntArray>, bookings: Array<IntArray>): Int {
        val capacity = IntArray(n + 1)
        trans.forEach {
            capacity[it[0]] += it[2]
            capacity[it[1]] -= it[2]
        }
        bookings.sortBy { it[0] }

        for (i in 1..n) {
            capacity[i] += capacity[i - 1]
        }

        val passengers = mutableListOf<Int>()
        var answer = 0
        var j = 0
        for (i in 1..n) {
            while (passengers.isNotEmpty() && passengers[0] == i) {
                passengers.removeAt(0)
                answer++

            }

            while (j < bookings.size && bookings[j][0] == i) {
                passengers.add(bookings[j][1])
                j++
            }

            passengers.sort()
            while (passengers.size > capacity[i]) {
                passengers.removeLast()
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            5,
            arrayOf(intArrayOf(1, 4, 2), intArrayOf(2, 5, 1)),
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 5),
                intArrayOf(2, 3),
                intArrayOf(2, 4),
                intArrayOf(2, 5),
                intArrayOf(2, 5),
                intArrayOf(3, 5),
                intArrayOf(3, 4)
            )
        )
    )
    println(
        T.solution(
            5,
            arrayOf(intArrayOf(2, 3, 1), intArrayOf(1, 5, 1)),
            arrayOf(
                intArrayOf(2, 5),
                intArrayOf(1, 5),
                intArrayOf(1, 3),
                intArrayOf(2, 4),
                intArrayOf(2, 5),
                intArrayOf(2, 3)
            )
        )
    )
    println(
        T.solution(
            8,
            arrayOf(intArrayOf(1, 8, 3), intArrayOf(3, 8, 1)),
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(5, 8),
                intArrayOf(2, 7),
                intArrayOf(3, 8),
                intArrayOf(2, 7),
                intArrayOf(2, 8),
                intArrayOf(3, 8),
                intArrayOf(6, 8),
                intArrayOf(7, 8),
                intArrayOf(5, 8),
                intArrayOf(2, 5),
                intArrayOf(2, 7),
                intArrayOf(3, 7),
                intArrayOf(3, 8)
            )
        )
    )
    println(
        T.solution(
            9, arrayOf(intArrayOf(1, 8, 3), intArrayOf(3, 9, 2), intArrayOf(1, 5, 3)), arrayOf(
                intArrayOf(1, 9),
                intArrayOf(5, 8),
                intArrayOf(2, 9),
                intArrayOf(3, 8),
                intArrayOf(2, 9),
                intArrayOf(1, 9),
                intArrayOf(8, 9),
                intArrayOf(3, 9),
                intArrayOf(1, 8),
                intArrayOf(6, 8),
                intArrayOf(7, 8),
                intArrayOf(5, 8),
                intArrayOf(3, 5),
                intArrayOf(3, 7),
                intArrayOf(4, 7),
                intArrayOf(5, 8)
            )
        )
    )
    println(
        T.solution(
            9, arrayOf(intArrayOf(2, 7, 2), intArrayOf(3, 9, 2), intArrayOf(1, 5, 3)), arrayOf(
                intArrayOf(1, 9),
                intArrayOf(4, 8),
                intArrayOf(2, 9),
                intArrayOf(5, 9),
                intArrayOf(3, 8),
                intArrayOf(2, 9),
                intArrayOf(1, 9),
                intArrayOf(8, 9),
                intArrayOf(3, 9),
                intArrayOf(1, 8),
                intArrayOf(6, 8),
                intArrayOf(3, 6),
                intArrayOf(7, 8),
                intArrayOf(5, 8),
                intArrayOf(3, 5),
                intArrayOf(2, 7),
                intArrayOf(1, 7),
                intArrayOf(2, 8)
            )
        )
    )
}