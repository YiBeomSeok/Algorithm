class Solution {
    fun solution(s: String): Int {
        var answer = 0
        
        if(s.length == 1) return 1
        
        var minLength = Int.MAX_VALUE
        for(len in 1 until s.length - 1) {
            var res = ""
            var prev = ""
            var count = 0
            for(i in 0 until s.length / len) {
                val curChunk = s.substring(i * len, i * len + len)
                if(prev == curChunk) {
                    count++
                } else {
                    if(count > 1) {
                        res = "$res$count$prev"
                    } else {
                        res = "$res$prev"
                    }
                    prev = curChunk
                    count = 1
                }
                
                if(i == s.length / len - 1) {
                    if(count > 1) {
                        res = "$res$count$prev"
                    } else {
                        res = "$res$prev"
                    }
                    if((i + 1) * len < s.length)
                        res += s.substring((i + 1) * len, s.length)
                }
            }
            minLength = minOf(minLength, res.length)
        }
        
        return minLength
    }
}