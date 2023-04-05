package inflearn2.kotlin.ch03.p3

import java.util.*

class Solution {
    fun solution(arrival: IntArray, state: IntArray): IntArray {
        val n = arrival.size

        val answer = IntArray(n)
        val enterQueue = ArrayDeque<Int>()
        val exitQueue = ArrayDeque<Int>()

        var curTime = 0
        var prevState = 1
        var arrivalIndex = 0
        var count = 0
        while (true) {
            if (enterQueue.isEmpty() && exitQueue.isEmpty() && arrivalIndex < n) {
                if (curTime < arrival[arrivalIndex]) {
                    curTime = arrival[arrivalIndex]
                    prevState = 1
                }
            }

            while (arrivalIndex < n && arrival[arrivalIndex] <= curTime) {
                when (state[arrivalIndex]) {
                    0 -> enterQueue.addLast(arrivalIndex)
                    1 -> exitQueue.addLast(arrivalIndex)
                }
                arrivalIndex++
            }

            if (enterQueue.isEmpty()) {
                answer[exitQueue.removeFirst()] = curTime
                prevState = 1
            } else if (exitQueue.isEmpty()) {
                answer[enterQueue.removeFirst()] = curTime
                prevState = 0
            } else {
                if (prevState == 0) {
                    answer[enterQueue.removeFirst()] = curTime
                } else {
                    answer[exitQueue.removeFirst()] = curTime
                }
            }

            count++
            curTime++
            if (count == n) break
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(Arrays.toString(T.solution(intArrayOf(0, 1, 1, 1, 2, 3, 8, 8), intArrayOf(1, 0, 0, 1, 0, 0, 1, 0))))
    println(Arrays.toString(T.solution(intArrayOf(3, 3, 4, 5, 5, 5), intArrayOf(1, 0, 1, 0, 1, 0))))
    println(
        Arrays.toString(
            T.solution(
                intArrayOf(2, 2, 2, 3, 4, 8, 8, 9, 10, 10),
                intArrayOf(1, 0, 0, 0, 1, 1, 0, 1, 1, 0)
            )
        )
    )
}