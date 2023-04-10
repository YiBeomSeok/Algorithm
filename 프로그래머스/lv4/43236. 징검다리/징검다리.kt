class Solution {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        var answer = 0
        
        val mRocks = rocks.copyOf(rocks.size + 1)
        mRocks[mRocks.size - 1] = distance
        mRocks.sort()
        
        var left = 0
        var right = distance
        
        while(left <= right) {
            val mid = (left + right) / 2
            
            var prev = 0
            var count = 0
            for(i in mRocks.indices) {
                if(mRocks[i] - prev < mid) {
                    count++
                } else {
                    prev = mRocks[i]
                }
            }
            
            if(count > n) {
                right = mid - 1
            } else {
                answer = maxOf(answer, mid)
                left = mid + 1
            }
        }
        
        return answer
    }
}