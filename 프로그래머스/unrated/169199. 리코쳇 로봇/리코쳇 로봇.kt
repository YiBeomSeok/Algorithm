class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(-1, 0, 1, 0)
    
    fun solution(board: Array<String>): Int {
        var answer: Int = 0
        val visited = Array(board.size) { IntArray(board[0].length) { Int.MAX_VALUE } }
        val mBoard = Array(board.size) { IntArray(board[0].length) }
        val rPos = intArrayOf(0, 0)
        val gPos = intArrayOf(0, 0)
        
        for(i in board.indices) {
            for(j in board[0].indices) {
                if(board[i][j] == '.') continue
                
                if(board[i][j] == 'R') {
                    rPos[0] = i
                    rPos[1] = j
                } else if(board[i][j] == 'G') {
                    mBoard[i][j] = 2
                    gPos[0] = i
                    gPos[1] = j
                } else if(board[i][j] == 'D') {
                    mBoard[i][j] = 1
                }
            }
        }
        
        val deque = ArrayDeque<IntArray>()
        deque.addLast(rPos)
        visited[rPos[0]][rPos[1]] = 0
        
        while(deque.isNotEmpty()) {
            val len = deque.size
            repeat(len) {
                val curPos = deque.removeFirst()
                
                for(dir in 0 until 4) {
                    var nY = curPos[0]
                    var nX = curPos[1]
                    
                    while(true) {
                        val nnY = nY + dy[dir]
                        val nnX = nX + dx[dir]
                        
                        if(nnY < 0 || nnY >= mBoard.size || nnX < 0 || nnX >= mBoard[0].size || mBoard[nnY][nnX] == 1) break
                        nY = nnY
                        nX = nnX
                    }

                    if((nY != curPos[0] || nX != curPos[1]) && visited[nY][nX] > visited[curPos[0]][curPos[1]] + 1) {
                        visited[nY][nX] = visited[curPos[0]][curPos[1]] + 1
                        if(mBoard[nY][nX] == 2) {
                            return visited[nY][nX]
                        }
                        deque.addLast(intArrayOf(nY, nX))
                    }
                }
            }
        }
        
        return -1
    }
}