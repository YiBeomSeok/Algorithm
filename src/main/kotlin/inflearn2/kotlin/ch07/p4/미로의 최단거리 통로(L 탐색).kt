package inflearn2.kotlin.ch07.p4

class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(-1, 0, 1, 0)

    fun solution(board: Array<IntArray>): Int {

        val deque = ArrayDeque<IntArray>()
        deque.addLast(intArrayOf(0, 0))

        var depth = 0
        while(deque.isNotEmpty()) {
            val len = deque.size
            repeat(len) {
                val curPos = deque.removeFirst()
                if(curPos[0] == 6 && curPos[1] == 6) return depth

                for(dir in 0 .. 3) {
                    val nY = curPos[0] + dy[dir]
                    val nX = curPos[1] + dx[dir]

                    if(nY in 0 .. 6 && nX in 0 .. 6 && board[nY][nX] == 0) {
                        deque.add(intArrayOf(nY, nX))
                        board[nY][nX] = 1
                    }
                }
            }
            depth++
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    val arr = arrayOf(
        intArrayOf(0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 1, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 1, 0, 0, 0),
        intArrayOf(1, 1, 0, 1, 0, 1, 1),
        intArrayOf(1, 1, 0, 1, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 1, 0, 0),
        intArrayOf(1, 0, 1, 0, 0, 0, 0)
    )
    val arr2 = arrayOf(
        intArrayOf(0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 1, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 1, 0, 0, 0),
        intArrayOf(1, 1, 0, 1, 1, 1, 1),
        intArrayOf(1, 1, 0, 1, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 1, 0, 0),
        intArrayOf(1, 0, 1, 0, 1, 0, 0)
    )
    println(T.solution(arr))
    println(T.solution(arr2))
}