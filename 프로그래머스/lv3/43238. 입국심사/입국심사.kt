class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        times.sort()
        
        var left = 1L
        var right = n.toLong() * times.last().toLong()
        
        while(left <= right) {
            val mid = (left + right) / 2
            var sum = 0L
            
            times.forEach {
                sum += mid / it
            }
            
            if(sum < n) {
                left = mid + 1
            } else {
                answer = mid
                right = mid - 1
            }
        }
        return answer
    }
}