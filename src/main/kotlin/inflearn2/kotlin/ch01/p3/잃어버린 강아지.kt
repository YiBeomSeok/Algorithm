package inflearn2.kotlin.ch01.p3

import java.util.*

class Point(var y: Int, var x: Int)

class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(-1, 0, 1, 0)

    fun solution(board: Array<IntArray>): Int {

        val man = Point(0, 0)
        val puppy = Point(0, 0)

        for(i in 0 until 10) {
            for(j in 0 until 10) {
                if(board[i][j] == 2) {
                    man.y = i
                    man.x = j
                    board[i][j] = 0
                } else if(board[i][j] == 3) {
                    puppy.y = i
                    puppy.x = j
                    board[i][j] = 0
                }
            }
        }

        var time = 0
        var dirMan = 0
        var dirPuppy = 0
        while(time < 10000) {
            time++

            val nextManY = man.y + dy[dirMan]
            val nextManX = man.x + dx[dirMan]
            if(nextManY == -1 || nextManY == 10 ||
                nextManX == -1 || nextManX == 10 ||
                board[nextManY][nextManX] == 1) {
                dirMan = (dirMan + 1) % 4
            } else {
                man.y = nextManY
                man.x = nextManX
            }

            val nextPuppyY = puppy.y + dy[dirPuppy]
            val nextPuppyX = puppy.x + dx[dirPuppy]
            if(nextPuppyY == -1 || nextPuppyY == 10 ||
                nextPuppyX == -1 || nextPuppyX == 10 ||
                board[nextPuppyY][nextPuppyX] == 1) {
                dirPuppy = (dirPuppy + 1) % 4
            } else {
                puppy.y = nextPuppyY
                puppy.x = nextPuppyX
            }

            if(puppy.y == man.y && puppy.x == man.x) {
                return time
            }
        }

        return time
    }
}

fun main() {
    val T = Solution()
    val arr1 = arrayOf(
        intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 0, 0, 0, 2, 0, 0),
        intArrayOf(1, 0, 0, 0, 0, 0, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 3, 0, 0, 0, 1),
        intArrayOf(0, 0, 0, 1, 0, 1, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 1, 0, 0, 0, 0, 0, 0)
    )
    println(T.solution(arr1))
    val arr2 = arrayOf(
        intArrayOf(1, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
        intArrayOf(0, 0, 1, 1, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 0, 1, 0, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 0, 0, 1, 0, 1, 0),
        intArrayOf(0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 0, 2, 1),
        intArrayOf(0, 0, 0, 1, 0, 1, 0, 0, 0, 1),
        intArrayOf(0, 1, 0, 1, 0, 0, 0, 0, 0, 3)
    )
    println(T.solution(arr2))
}
