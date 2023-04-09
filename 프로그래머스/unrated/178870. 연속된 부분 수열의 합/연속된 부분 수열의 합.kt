class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        val n = sequence.size
        var answer: IntArray = intArrayOf(0, n - 1)
        val dp = IntArray(n)
        dp[0] = sequence[0]
        for(i in 1 until n) {
            dp[i] = sequence[i] + dp[i - 1]
        }
        
        var i = 0
        var j = 0
        while(i < n && j < n) {
            val sum = dp[j] - dp[i] + sequence[i]
            
            if(sum < k) {
                j++
            } else if(sum > k) {
                i++
            } else {
                if(answer[1] - answer[0] > j - i) {
                    answer[0] = i
                    answer[1] = j
                }
                j++
            }
        }
        return answer
    }
}