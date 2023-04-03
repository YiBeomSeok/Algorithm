package inflearn2.kotlin.ch07.p1

class Solution {
    fun solution(nums: IntArray): Int {
        return bfs(nums)
    }

    private fun bfs(nums: IntArray): Int {
        val visited = IntArray(nums.size) { 0 }
        val queue = ArrayDeque<Int>()
        val result = -1

        queue.addLast(0)

        while (queue.isNotEmpty()) {
            val curTile = queue.removeFirst()

            if (curTile == nums.size - 1) return visited[curTile]
            if (nums[curTile] == 0) continue

            for (i in 1 .. nums[curTile]) {
                val nextTile = curTile + i

                if (nextTile >= nums.size) break
                else if (visited[nextTile] != 0) continue

                visited[nextTile] += visited[curTile] + 1
                queue.add(nextTile)
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val T = Solution()
    println(T.solution(intArrayOf(2, 2, 1, 2, 1, 1)))
    println(T.solution(intArrayOf(1, 0, 1, 1, 3, 1, 2, 1)))
    println(T.solution(intArrayOf(2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1)))
    println(T.solution(intArrayOf(1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1)))
    println(T.solution(intArrayOf(1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1)))
}