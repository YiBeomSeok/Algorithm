package inflearn2.kotlin.ch03.p3

import java.util.*

class Solution {
    fun solution(arrival: IntArray, state: IntArray): IntArray {
        val n = arrival.size
        val enter = ArrayDeque<Int>()
        val exit = ArrayDeque<Int>()
        var prev = 1
        val answer = IntArray(n)

        var t = 0
        var i = 0
        var cnt = 0
        while(true) {
            if(enter.isEmpty() && exit.isEmpty() && i < n) {
                if(t < arrival[i]) {
                    t = arrival[i]
                    prev = 1
                }
            }

            while(i < n && arrival[i] <= t) {
                if(state[i] == 0) enter.addLast(i)
                else exit.addLast(i)
                i++
            }

            if(prev == 1) {
                if(exit.isNotEmpty()) {
                    answer[exit.removeFirst()] = t
                    prev = 1
                }
                else {
                    answer[enter.removeFirst()] = t
                    prev = 0
                }
            } else if(prev == 0) {
                if(enter.isNotEmpty()) {
                    answer[enter.removeFirst()] = t
                    prev = 0
                } else {
                    answer[exit.removeFirst()] = t
                    prev = 1
                }
            }
            cnt++
            if(cnt == n) break
            //
            t++
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