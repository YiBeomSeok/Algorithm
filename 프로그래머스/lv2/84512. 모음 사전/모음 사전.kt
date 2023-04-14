class Solution {
    var find = false
    var count = 0  // 몇 번 걸렸는지
    var answer = 0
    var alphabet = charArrayOf('A', 'E', 'I', 'O', 'U')
    
    fun solution(word: String): Int {
        
        dfs("", 0, word)
        
        return answer
    }
    
    private fun dfs(curWord: String, depth: Int, targetWord: String) {
        if(find) return

        if(curWord == targetWord) {
            find = true
            answer = count
        } else if(depth == 5) {
            return
        } else {
           for(i in 0 until 5) {
               this.count++
               dfs("$curWord${alphabet[i]}", depth + 1, targetWord)
           } 
        }
    }
}