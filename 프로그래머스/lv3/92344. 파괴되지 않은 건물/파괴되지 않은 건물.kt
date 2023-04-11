class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer: Int = 0
        
        val sumBoard = Array(board.size + 1) { IntArray(board[0].size + 1) { 0 } }
        
        skill.forEach {
            if(it[0] == 1) {
                sumBoard[it[1]][it[2]] -= it[5]
                sumBoard[it[1]][it[4] + 1] += it[5]
                sumBoard[it[3] + 1][it[2]] += it[5]
                sumBoard[it[3] + 1][it[4] + 1] -= it[5]
            }
            else if(it[0] == 2) {
                sumBoard[it[1]][it[2]] += it[5]
                sumBoard[it[1]][it[4] + 1] -= it[5]
                sumBoard[it[3] + 1][it[2]] -= it[5]
                sumBoard[it[3] + 1][it[4] + 1] += it[5]
            }
        }
        
        for(r in sumBoard.indices) {
            for(c in 1 until sumBoard[0].size) {
                sumBoard[r][c] += sumBoard[r][c - 1]
            }
        }
        
        for(c in 0 until sumBoard[0].size) {
            for(r in 1 until sumBoard.size) {
                sumBoard[r][c] += sumBoard[r - 1][c]
            }
        }
        
        for(r in board.indices) {
            for(c in board[0].indices) {
                board[r][c] += sumBoard[r][c]
                if(board[r][c] >= 1) answer++
            }
        }
        
        return answer
    }
}