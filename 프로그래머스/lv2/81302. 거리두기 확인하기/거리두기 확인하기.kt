class Solution {
    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)

    fun solution(places: Array<Array<String>>): IntArray {
        return places.map { searchPlace(it) }.toIntArray()
    }

    private fun searchPlace(places: Array<String>): Int {
        for(i in 0 until 5) {
            for(j in 0 until 5) {
                if(places[i][j] == 'P')
                    if(searchDir4(i, j, places) == 0) return 0
            }
        }
        return 1
    }

    private fun searchDir4(x: Int, y: Int, places: Array<String>): Int {
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue

            if (places[nx][ny] == 'P') return 0
            if (places[nx][ny] == 'O') {
                for (j in 0 until 4) {
                    val nnx = nx + dx[j]
                    val nny = ny + dy[j]

                    if (x == nnx && y == nny) continue
                    if (nnx < 0 || nnx > 4 || nny < 0 || nny > 4) continue

                    if (places[nnx][nny] == 'P') return 0
                }
            }
        }
        return 1
    }
}