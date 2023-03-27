import java.io.*
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

class Solution(val n: Int, val board: Array<IntArray>) {
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var max = Int.MIN_VALUE

    fun solution(): Int {
        dfs(board, 0)
        return max
    }

    fun dfs(curBoard: Array<IntArray>, depth: Int) {
        if (depth == 5) {
            max = maxOf(max, findMax(curBoard))
        } else {
            for (i in 0 until 4) {
                val nextBoard = movedBoard(curBoard, i)
                dfs(nextBoard, depth + 1)
            }
        }
    }

    fun isNotEqual(curBoard: Array<IntArray>, nextBoard: Array<IntArray>): Boolean {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (curBoard[i][j] != nextBoard[i][j]) return true
            }
        }
        return false
    }

    fun findMax(curBoard: Array<IntArray>): Int {
        var max = Int.MIN_VALUE
        for (i in 0 until n) {
            for (j in 0 until n) {
                max = maxOf(max, curBoard[i][j])
            }
        }
        return max
    }

    fun pushBoard(targetBoard: Array<IntArray>, dir: Int) {
        when (dir) {
            0 -> {
                for (y in 0 until n) {
                    for (x in n - 1 downTo 0) {
                        if (targetBoard[y][x] == 0) {  // 0이면 밀어줘야함
                            for (i in x - 1 downTo 0) {
                                if (targetBoard[y][i] != 0) {
                                    targetBoard[y][x] = targetBoard[y][i]
                                    targetBoard[y][i] = 0
                                    break
                                }
                            }
                        }
                    }
                }
            }

            1 -> {
                for (x in 0 until n) {
                    for (y in n - 1 downTo 0) {
                        if (targetBoard[y][x] == 0) {
                            for (i in y - 1 downTo 0) {
                                if (targetBoard[i][x] != 0) {
                                    targetBoard[y][x] = targetBoard[i][x]
                                    targetBoard[i][x] = 0
                                    break
                                }
                            }
                        }
                    }
                }
            }

            2 -> {
                for (y in 0 until n) {
                    for (x in 0 until n) {
                        if (targetBoard[y][x] == 0) {
                            for (i in x + 1 until n) {
                                if (targetBoard[y][i] != 0) {
                                    targetBoard[y][x] = targetBoard[y][i]
                                    targetBoard[y][i] = 0
                                    break
                                }
                            }
                        }
                    }
                }

            }

            3 -> {
                for (x in 0 until n) {
                    for (y in 0 until n) {
                        if (targetBoard[y][x] == 0) {
                            for (i in y + 1 until n) {
                                if (targetBoard[i][x] != 0) {
                                    targetBoard[y][x] = targetBoard[i][x]
                                    targetBoard[i][x] = 0
                                    break
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    fun movedBoard(curBoard: Array<IntArray>, dir: Int): Array<IntArray> {
        val nextBoard = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            nextBoard[i] = curBoard[i].clone()
        }
        // 해당 방향으로 미는 작업부터
        pushBoard(nextBoard, dir)

        when (dir) {
            0 -> {
                for (y in 0 until n) {
                    var x = n - 1
                    while (x >= 1) {
                        if (nextBoard[y][x - 1] == nextBoard[y][x]) {
                            nextBoard[y][x] *= 2
                            nextBoard[y][x - 1] = 0
                            x--
                        }
                        x--
                    }
                }
            }

            1 -> {
                for (x in 0 until n) {
                    var y = n - 1
                    while (y >= 1) {
                        if (nextBoard[y - 1][x] == nextBoard[y][x]) {
                            nextBoard[y][x] *= 2
                            nextBoard[y - 1][x] = 0
                            y--
                        }
                        y--
                    }
                }

            }

            2 -> {
                for (y in 0 until n) {
                    var x = 0
                    while (x < n - 1) {
                        if (nextBoard[y][x + 1] == nextBoard[y][x]) {
                            nextBoard[y][x] *= 2
                            nextBoard[y][x + 1] = 0
                            x++
                        }
                        x++
                    }
                }

            }

            3 -> {
                for (x in 0 until n) {
                    var y = 0
                    while (y < n - 1) {
                        if (nextBoard[y + 1][x] == nextBoard[y][x]) {
                            nextBoard[y][x] *= 2
                            nextBoard[y + 1][x] = 0
                            y++
                        }
                        y++
                    }
                }

            }
        }
        pushBoard(nextBoard, dir)
        return nextBoard
    }

}

fun main() {
    val n = br.readLine().toInt()
    val board = Array(n) {
        val st = StringTokenizer(br.readLine())
        IntArray(n) {
            st.nextToken().toInt()
        }
    }

    val sol = Solution(n, board)
    print(sol.solution())
}