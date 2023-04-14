class Solution {
    var answer = -1
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        
        dfs(k, dungeons, 0, BooleanArray(dungeons.size) { false })
        return answer
    }
    
    private fun dfs(curK: Int, dungeons: Array<IntArray>, depth: Int, visited: BooleanArray) {
        answer = maxOf(answer, depth)
        
        for(i in dungeons.indices) {   
            if(!visited[i] && curK >= dungeons[i][0]) {    
                visited[i] = true
                dfs(curK - dungeons[i][1], dungeons, depth + 1, visited)
                visited[i] = false
            }
        }
    }
}