class Solution {
    
    var transCount = 0
    var removedZeroCount = 0
    
    fun solution(s: String): IntArray {
        
        var next = s
        while(next != "1") {
            next = binaryTransform(next)
            transCount++
        }
        return intArrayOf(transCount,removedZeroCount)
    }
    
    private fun binaryTransform(s: String): String {
        val sb = StringBuilder()
        for(ch in s) {
            if(ch == '1')
                sb.append(ch)
            else if(ch == '0')
                removedZeroCount++
        }
        
        return sb.length.toString(2)
    }
}