package inflearn2.kotlin.ch03.p6

import java.util.*

class Solution {
    fun solution(n: Int, meetings: Array<IntArray>): Int {
        var answer = 0
        val res = IntArray(n)
        val ends = PriorityQueue(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        val rooms = TreeSet<Int>()

        meetings.sortBy { it[0] }

        for((i, value) in meetings.withIndex()) {
            while(ends.isNotEmpty()) {
                if(value[0] >= ends.peek()[0]) {
                    rooms.remove(ends.poll()[1])
                }
                else break
            }

            var endTime = value[1]
            val duration = value[1] - value[0]
            if(ends.size == n) {
                val first = ends.first()
                endTime = first[0] + duration
                while(ends.isNotEmpty()) {
                    if(ends.peek()[0] == first[0]) {
                        rooms.remove(ends.poll()[1])
                    } else {
                        break
                    }
                }
            }

            for(i in 0 until n) {
                if(!rooms.contains(i)) {
                    rooms.add(i)
                    ends.offer(intArrayOf(endTime, i))
                    res[i]++
                    break
                }
            }
        }

        var max = 0
        for((i, value) in res.withIndex()) {
            if(max < value) {
                max = value
                answer = i
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            2,
            arrayOf(intArrayOf(0, 5), intArrayOf(2, 7), intArrayOf(4, 5), intArrayOf(7, 10), intArrayOf(9, 12))
        )
    )
    println(
        T.solution(
            3,
            arrayOf(
                intArrayOf(3, 9),
                intArrayOf(1, 10),
                intArrayOf(5, 8),
                intArrayOf(10, 15),
                intArrayOf(9, 14),
                intArrayOf(12, 14),
                intArrayOf(15, 20)
            )
        )
    )
    println(
        T.solution(
            3,
            arrayOf(
                intArrayOf(1, 30),
                intArrayOf(2, 15),
                intArrayOf(3, 10),
                intArrayOf(4, 12),
                intArrayOf(6, 10)
            )
        )
    )
    println(
        T.solution(
            4,
            arrayOf(
                intArrayOf(3, 20),
                intArrayOf(1, 25),
                intArrayOf(5, 8),
                intArrayOf(10, 15),
                intArrayOf(9, 14),
                intArrayOf(12, 14),
                intArrayOf(15, 20)
            )
        )
    )
}