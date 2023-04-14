package inflearn2.kotlin.ch04.p7

const val END = 0
const val START = 1

class Solution {
    fun solution(meetings: Array<IntArray>): Int {
        var answer = 0

        val sortedMeetings = mutableListOf<Meeting>()
        meetings.forEach {
            sortedMeetings.add(Meeting(it[0], START))
            sortedMeetings.add(Meeting(it[1], END))
        }
        sortedMeetings.sortWith(compareBy<Meeting> { it.time }.thenBy { it.type })

        var count = 0
        for (meeting in sortedMeetings) {
            if (meeting.type == END) count--
            else if (meeting.type == START) {
                count++
                answer = maxOf(answer, count)
            }
        }

        return answer
    }

    class Meeting(val time: Int, val type: Int)
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(arrayOf(intArrayOf(0, 10), intArrayOf(20, 25), intArrayOf(5, 15), intArrayOf(2, 5))))
    println(
        T.solution(
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
            arrayOf(
                intArrayOf(0, 5),
                intArrayOf(2, 7),
                intArrayOf(4, 5),
                intArrayOf(7, 10),
                intArrayOf(9, 12)
            )
        )
    )
}