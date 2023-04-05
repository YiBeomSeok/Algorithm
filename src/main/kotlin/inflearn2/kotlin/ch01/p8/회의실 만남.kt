package inflearn2.kotlin.ch01.p8

import java.util.*

class Solution {
    fun solution(enter: IntArray, exit: IntArray): IntArray {
        val meets = Array(enter.size + 1) { HashSet<Int>() }
        val room = mutableListOf<Int>()

        var enIdx = 0
        var exIdx = 0
        while (enIdx < enter.size && exIdx < exit.size) {

            while (!room.contains(exit[exIdx])) {
                room.forEach {
                    meets[it].add(enter[enIdx])
                    meets[enter[enIdx]].add(it)
                }
                room.add(enter[enIdx])

                enIdx++
            }
            room.remove(exit[exIdx])
            exIdx++
        }

        return IntArray(enter.size) { meets[it + 1].size }
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(Arrays.toString(T.solution(intArrayOf(1, 2, 3, 4), intArrayOf(2, 4, 1, 3))))
    println(Arrays.toString(T.solution(intArrayOf(1, 2, 5, 3, 4), intArrayOf(2, 3, 1, 4, 5))))
    println(Arrays.toString(T.solution(intArrayOf(1, 3, 2, 4, 5, 7, 6, 8), intArrayOf(2, 3, 5, 6, 1, 4, 8, 7))))
    println(Arrays.toString(T.solution(intArrayOf(1, 4, 7, 2, 3, 5, 6), intArrayOf(5, 2, 6, 1, 7, 3, 4))))
    println(Arrays.toString(T.solution(intArrayOf(1, 4, 2, 3), intArrayOf(2, 1, 4, 3))))
}