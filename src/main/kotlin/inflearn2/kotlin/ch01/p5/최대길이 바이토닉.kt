package inflearn2.kotlin.ch01.p5


class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0
        val peaks = mutableListOf<Int>()

        for(i in 1 until nums.size - 1) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peaks.add(i)
            }
        }

        for(peakIndex in peaks) {
            var curPeakCount = 1
            var l = peakIndex - 1
            var r = peakIndex + 1

            while(l >= 0) {
                if(nums[l] < nums[l + 1]){
                    curPeakCount++
                } else {
                    break
                }
                l--
            }

            while(r < nums.size) {
                if(nums[r] < nums[r - 1]) {
                    curPeakCount++
                } else {
                    break
                }
                r++
            }

            answer = maxOf(answer, curPeakCount)
        }

        return answer
    }
}

fun main() {
    val T = Solution()
    println(T.solution(intArrayOf(1, 2, 1, 2, 3, 2, 1)))
    println(T.solution(intArrayOf(1, 1, 2, 3, 5, 7, 4, 3, 1, 2)))
    println(T.solution(intArrayOf(3, 2, 1, 3, 2, 4, 6, 7, 3, 1)))
    println(T.solution(intArrayOf(1, 3, 1, 2, 1, 5, 3, 2, 1, 1)))
}