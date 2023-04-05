package inflearn2.kotlin.ch01.p6

class Solution {
    fun solution(fruit: Array<IntArray>): Int {
        var answer = 0
        val n = fruit.size
        val ch = IntArray(n)
        for (i in 0 until n) {
            if (ch[i] == 1) continue
            if (!isMinUnique(fruit[i])) continue
            for (j in i + 1 until n) {
                if (ch[j] == 1) continue
                if (!isMinUnique(fruit[j])) continue
                val a = getMinIndex(fruit[i])
                val b = getMinIndex(fruit[j])
                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++
                        fruit[i][b]--
                        fruit[j][b]++
                        fruit[j][a]--
                        ch[i] = 1
                        ch[j] = 1
                        break
                    }
                }
            }
        }
        for (x in fruit) {
            answer += getMin(x)
        }
        return answer
    }

    private fun getMin(fruit: IntArray): Int {
        var min = 100
        for (x in fruit) {
            min = minOf(min, x)
        }
        return min
    }

    private fun isMinUnique(fruit: IntArray): Boolean {
        val min = getMin(fruit)
        return fruit.count { it == min } == 1
    }

    private fun getMinIndex(fruit: IntArray): Int {
        val min = getMin(fruit)
        return fruit.indexOfFirst { it == min }
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(
        T.solution(
            arrayOf(
                intArrayOf(10, 20, 30),
                intArrayOf(12, 15, 20),
                intArrayOf(20, 12, 15),
                intArrayOf(15, 20, 10),
                intArrayOf(10, 15, 10)
            )
        )
    )
    println(T.solution(arrayOf(intArrayOf(10, 9, 11), intArrayOf(15, 20, 25))))
    println(
        T.solution(
            arrayOf(
                intArrayOf(0, 3, 27),
                intArrayOf(20, 5, 5),
                intArrayOf(19, 5, 6),
                intArrayOf(10, 10, 10),
                intArrayOf(15, 10, 5),
                intArrayOf(3, 7, 20)
            )
        )
    )
    println(
        T.solution(
            arrayOf(
                intArrayOf(3, 7, 20),
                intArrayOf(10, 15, 5),
                intArrayOf(19, 5, 6),
                intArrayOf(10, 10, 10),
                intArrayOf(15, 10, 5),
                intArrayOf(3, 7, 20),
                intArrayOf(12, 12, 6),
                intArrayOf(10, 20, 0),
                intArrayOf(5, 10, 15)
            )
        )
    )
}