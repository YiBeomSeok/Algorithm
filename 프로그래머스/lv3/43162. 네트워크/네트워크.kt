class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        
        val visited = IntArray(n)
        
        for(i in computers.indices) {
            if(visited[i] == 1) continue
            
            val deque = ArrayDeque<Int>()
            deque.addLast(i)
            
            while(deque.isNotEmpty()) {
                val len = deque.size
                repeat(len) {
                    val curNode = deque.removeFirst()
                    visited[curNode] = 1
                    
                    for(j in 0 until n) {
                        if(computers[curNode][j] == 1 && visited[j] != 1) {
                            deque.addLast(j)
                        }
                    }
                }
            }
            
            answer++
        }
        return answer
    }
}