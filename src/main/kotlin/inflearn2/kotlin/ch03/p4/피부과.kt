package inflearn2.kotlin.ch03.p4

import java.util.*

class Solution {
    fun solution(laser: IntArray, enter: Array<String>): Int {
        var answer = 0
        val n: Int = enter.size
        val inList = Array(n) { IntArray(2) }
        for (i in 0 until n) {
            val a = getTime(enter[i].split(" ")[0])
            val b = enter[i].split(" ")[1].toInt()
            inList[i][0] = a
            inList[i][1] = b
        }
        val Q: Queue<Int> = LinkedList()
        Q.offer(inList[0][1])
        var fT = inList[0][0]
        var pos = 1
        for (t in fT..1200) {
            if (pos < n && t == inList[pos][0]) {
                if (Q.isEmpty() && inList[pos][0] > fT) fT = inList[pos][0]
                Q.offer(inList[pos][1])
                pos++
            }
            if (t == fT && !Q.isEmpty()) {
                val idx = Q.poll()
                fT += laser[idx]
            }
            answer = Math.max(answer, Q.size)
        }
        return answer
    }

    private fun getTime(timeString: String): Int {
        val split = timeString.split(":")
        return split[0].toInt() * 60 + split[1].toInt()
    }
}

class Solution2 {
    class Schedule(val time: Int, val state: String) : Comparable<Schedule> {
        override fun compareTo(other: Schedule): Int {
            return if (this.time == other.time) this.state.compareTo(other.state) else this.time - other.time
        }
    }

    fun solution(laser: IntArray, enter: Array<String>): Int {
        val schedules = mutableListOf<Schedule>()

        for (info in enter) {
            val split = info.split(" ")
            val timeString = split[0]
            val durationTime = laser[split[1].toInt()]
            val start = getTime(timeString)
            val end = start + durationTime

            schedules.add(Schedule(start, "s"))
            schedules.add(Schedule(end, "e"))
        }

        schedules.sort()

        var answer = 0
        var waitingCount = 0
        for (schedule in schedules) {
            if (schedule.state == "s") {
                waitingCount++
                answer = maxOf(waitingCount - 1, answer)
            } else {
                waitingCount--
            }
        }
        return answer
    }

    private fun getTime(timeString: String): Int {
        val split = timeString.split(":")
        return split[0].toInt() * 60 + split[1].toInt()
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            intArrayOf(30, 20, 25, 15),
            arrayOf("10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2")
        )
    )
    println(
        T.solution(
            intArrayOf(30, 20, 25, 15),
            arrayOf(
                "10:23 0",
                "10:40 3",
                "10:42 2",
                "10:52 3",
                "15:10 0",
                "15:20 3",
                "15:22 1",
                "15:23 0",
                "15:25 0"
            )
        )
    )
    println(
        T.solution(
            intArrayOf(30, 20, 25, 15),
            arrayOf("10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1")
        )
    )
}