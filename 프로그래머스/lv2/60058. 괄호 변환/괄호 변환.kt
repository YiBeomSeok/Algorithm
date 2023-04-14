const val INVALID = 0
const val VALID_X = 1
const val VALID_O = 2

class Solution {
    fun solution(p: String): String {
        return dfs(p)
    }
    
    private fun dfs(p: String): String {
        if(p == "") return ""
        
        for(i in 0 .. p.length) {
            if(p.substring(0 until i) == "") continue
            
            if(isValidString(p.substring(0 until i)) >= 1) {
                val u = p.substring(0 until i)
                val v = p.substring(i until p.length)
                
                println("p=$p u=$u v=$v")
                
                if(isValidString(u) == VALID_O) {
                    return u + dfs(v)
                }
                else {
                    var tmpString = "(${dfs(v)})"
                    return "$tmpString${tableSpin(u)}"
                }
            }
        }
        
        return p
    }
    
    private fun isValidString(str: String): Int {
        var left = 0
        var right = 0
        var flag = false
        
        for(ch in str) {
            if(ch == '(') {
                left++
            } else if(ch == ')') {
                right++
            }
            if(right > left)
                flag = true
        }
        
        return if(right != left) INVALID else if(flag) VALID_X else VALID_O
    }
    
    private fun tableSpin(u: String): String {
        val res = mutableListOf<Char>()
        
        val tmp = u.substring(1 until u.length - 1)
        for(ch in tmp) {
            if(ch == '(') res.add(')')
            else res.add('(')
        }
        
        return res.joinToString("")
    }
}