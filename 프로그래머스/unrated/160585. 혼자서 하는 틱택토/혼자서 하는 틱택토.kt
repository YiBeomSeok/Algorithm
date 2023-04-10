class Solution {
    fun solution(board: Array<String>): Int {
       
        var oCrossL = 0
        var oCrossR = 0
        val oCol = IntArray(3)
        val oRow = IntArray(3)
        var oCount = 0
        
        var xCrossL = 0
        var xCrossR = 0
        val xCol = IntArray(3)
        val xRow = IntArray(3)
        var xCount = 0
        
        for(i in 0 until 3) {
            for(j in 0 until 3) {
                when(board[i][j]) {
                    'O' -> {
                        if(i == j) oCrossR++
                        if(2 - i == j) oCrossL++
                        oCol[j]++
                        oRow[i]++
                        oCount++
                    }
                    'X' -> {
                        if(i == j) xCrossR++
                        if(2 - i == j) xCrossL++
                        xCol[j]++
                        xRow[i]++
                        xCount++
                    }
                }
            }
        }
        
        if(oCount > xCount + 1) return 0
        if(oCount < xCount) return 0
        
        var oWin = false
        var xWin = false
        oCol.forEach { if(it == 3) oWin = true }
        oRow.forEach { if(it == 3) oWin = true }
        if(oCrossL == 3) oWin = true
        if(oCrossR == 3) oWin = true
        xCol.forEach { if(it == 3) xWin = true }
        xRow.forEach { if(it == 3) xWin = true }
        if(xCrossL == 3) xWin = true
        if(xCrossR == 3) xWin = true
        
        if(oWin && xWin) return 0
        
        if(oWin) {
            if(oCount != xCount + 1) return 0
        } else if(xWin) {
            if(oCount != xCount) return 0
        }
        
        return 1
    }
}
