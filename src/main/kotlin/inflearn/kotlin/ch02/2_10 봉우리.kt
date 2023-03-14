package inflearn.kotlin.ch02

object `2_10 봉우리` {

    fun solution(n: Int, map: Array<IntArray>): Int {
        var count = 0

        val dx = intArrayOf(1, 0, -1, 0)
        val dy = intArrayOf(0, 1, 0, -1)

        for((i, low) in map.withIndex()) {
            for((j, value) in low.withIndex()) {
                var isTop = 1
                for(k in 0 until 4) {
                    val nx = j + dx[k]
                    val ny = i + dy[k]
                    if(nx < 0 || nx >= n) continue
                    if(ny < 0 || ny >= n) continue

                    if(value < map[ny][nx]) {
                        isTop = 0
                        break
                    }
                }
                count += isTop
            }
        }

        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val n = readln().toInt()
        val map: Array<IntArray> = Array(n) { IntArray(n) }
        (0 until n).forEach { i ->
            map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
        }

        println(solution(n, map))
    }
}