class Solution {
    private var minFriends = 0
    
    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        minFriends = n + 1
        
        val extendedWeak = IntArray(weak.size * 2)
        for(i in weak.indices) {
            extendedWeak[i] = weak[i]
            extendedWeak[i + weak.size] = weak[i] + n
        }

        for(i in weak.indices) {
            checkWalls(
                extendedWeak, dist, BooleanArray(dist.size), 
                n, i, weak.size + i, 0
            )
        }
        
        return if (minFriends > n) -1 else minFriends
    }
    
    private fun checkWalls(
        extendedWeak: IntArray, dist: IntArray, visited: BooleanArray,
        n: Int, start: Int, end: Int, friendsUsed: Int,
    ) {
        if(start >= end) {
            minFriends = minOf(minFriends, friendsUsed)
            return
        }
        
        for (i in dist.indices) {
            if(visited[i]) continue
            
            visited[i] = true
            var idx = start + 1
            
            while(idx < end && extendedWeak[idx] - extendedWeak[start] <= dist[i]) {
                idx++
            }
            
            checkWalls(extendedWeak, dist, visited, n, idx, end, friendsUsed + 1)
            visited[i] = false
        }
    }
}