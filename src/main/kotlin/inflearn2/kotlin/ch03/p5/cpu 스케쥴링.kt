package inflearn2.kotlin.ch03.p5

import java.util.*

class Task(val number: Int, val duration: Int) : Comparable<Task> {
    override fun compareTo(other: Task): Int {
        return if (duration == other.duration) number - other.number else duration - other.duration
    }
}

class Solution {
    // 틀린 풀이라고 할 수 있는 비효율(까진 아니지만 더 좋은 코드 존재)
    fun solution(tasks: Array<IntArray>): IntArray {
        val answer = IntArray(tasks.size)
        val taskHashMap = HashMap<Int, MutableList<Task>>()
        val waitingPQ = PriorityQueue<Task>()

        for ((i, value) in tasks.withIndex()) {
            taskHashMap[value[0]] = taskHashMap.getOrDefault(value[0], mutableListOf()).apply { add(Task(i, value[1])) }
        }

        var finishTime = 0
        var time = 0
        var processed = 0
        while(processed < tasks.size) {
            if(taskHashMap.contains(time)) {
                taskHashMap[time]?.forEach {
                    waitingPQ.add(it)
                }
            }
            if(time == finishTime || finishTime == 0) {
                if(waitingPQ.isNotEmpty()) {
                    val cpuTask = waitingPQ.poll()
                    answer[processed] = cpuTask.number
                    processed++
                    finishTime = time + cpuTask.duration
                } else {
                    finishTime = 0
                }
            }

            //
            time++
        }
        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    intArrayOf(2, 3),
                    intArrayOf(1, 2),
                    intArrayOf(8, 2),
                    intArrayOf(3, 1),
                    intArrayOf(10, 2)
                )
            )
        )
    )
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    intArrayOf(5, 2),
                    intArrayOf(7, 3),
                    intArrayOf(1, 3),
                    intArrayOf(1, 5),
                    intArrayOf(2, 2),
                    intArrayOf(1, 1)
                )
            )
        )
    )
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(1, 3),
                    intArrayOf(3, 3),
                    intArrayOf(8, 2),
                    intArrayOf(1, 5),
                    intArrayOf(2, 2),
                    intArrayOf(1, 1)
                )
            )
        )
    )
    println(
        Arrays.toString(
            T.solution(
                arrayOf(
                    intArrayOf(999, 1000),
                    intArrayOf(996, 1000),
                    intArrayOf(998, 1000),
                    intArrayOf(999, 7)
                )
            )
        )
    )
}