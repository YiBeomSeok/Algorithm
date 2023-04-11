class Solution {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val offset = key.size - 1

        for (r in 0 until offset + lock.size) {
            for (c in 0 until offset + lock.size) {
                for (rot in 0 until 4) {
                    val arr = Array(58) { IntArray(58) }
                    for (i in lock.indices) {
                        for (j in lock.indices) {
                            arr[offset + i][offset + j] = lock[i][j]
                        }
                    }

                    match(arr, key, rot, r, c)
                    if (check(arr, offset, lock.size)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun match(arr: Array<IntArray>, key: Array<IntArray>, rot: Int, r: Int, c: Int) {
        val n = key.size

        for (i in 0 until n) {
            for (j in 0 until n) {
                when (rot) {
                    0 -> {
                        arr[r + i][c + j] += key[i][j]
                    }
                    1 -> {
                        arr[r + i][c + j] += key[n - 1 - j][i]
                    }
                    2 -> {
                        arr[r + i][c + j] += key[n - 1 - i][n - 1 - j]
                    }
                    3 -> {
                        arr[r + i][c + j] += key[j][n - 1 - i]
                    }
                }
            }
        }
    }

    private fun check(arr: Array<IntArray>, offset: Int, n: Int): Boolean {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (arr[offset + i][offset + j] != 1) {
                    return false
                }
            }
        }
        return true
    }
}