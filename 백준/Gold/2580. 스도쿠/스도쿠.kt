import java.util.Scanner

fun main() {
    val sudoku = Array(9) { IntArray(9) }
    val scanner = Scanner(System.`in`)
    
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            sudoku[i][j] = scanner.nextInt()
        }
    }
    
    solveSudoku(sudoku, 0, 0)
    
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            print("${sudoku[i][j]} ")
        }
        println()
    }
}

fun solveSudoku(sudoku: Array<IntArray>, row: Int, col: Int): Boolean {
    if (row == 9) {
        return true
    }
    
    var nextRow = row
    var nextCol = col
    
    if (col == 8) {
        nextRow++
        nextCol = 0
    } else {
        nextCol++
    }
    
    if (sudoku[row][col] != 0) {
        return solveSudoku(sudoku, nextRow, nextCol)
    }
    
    for (i in 1..9) {
        if (isValid(sudoku, row, col, i)) {
            sudoku[row][col] = i
            if (solveSudoku(sudoku, nextRow, nextCol)) {
                return true
            }
            sudoku[row][col] = 0
        }
    }
    
    return false
}

fun isValid(sudoku: Array<IntArray>, row: Int, col: Int, num: Int): Boolean {
    for (i in 0 until 9) {
        if (sudoku[row][i] == num || sudoku[i][col] == num) {
            return false
        }
    }
    
    val boxRowStart = row - row % 3
    val boxColStart = col - col % 3
    
    for (i in boxRowStart until boxRowStart + 3) {
        for (j in boxColStart until boxColStart + 3) {
            if (sudoku[i][j] == num) {
                return false
            }
        }
    }
    
    return true
}
