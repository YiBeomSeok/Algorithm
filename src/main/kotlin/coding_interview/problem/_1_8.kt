package coding_interview.problem

class MatrixUtils {
    fun toZeroColAndRowOf(n: Int, matrix: Array<IntArray>) {
        val points = ArrayList<IntArray>()

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    points.add(intArrayOf(i, j))
                }
            }
        }

        while(points.isNotEmpty()) {
            val point = points.removeLast()
            val i = point[0]
            val j = point[1]

            for(st in 0 until n) {
                matrix[st][j] = 0
                matrix[i][st] = 0
            }
        }

        points.map { ints ->
            ints.map { anInt ->
                print("$anInt ")
            }
            println()
        }
    }

    // 공간복잡도를 개선한 코드
    fun toZeroColAndRowOf(matrix: Array<IntArray>) {
        var rowHasZero = false
        var colHasZero = false

        // 첫 번째 행과 열에 0이 있는지 확인한다
        for (i in matrix.indices) {
            if(matrix[0][i] == 0) {
                rowHasZero = true
            }
            if(matrix[i][0] == 0) {
                colHasZero = true
            }
            if(rowHasZero && colHasZero) break
        }

        // 나머지 배열에 0이 있는지 확인한다
        for (i in 1 until matrix.size) {
            for(j in 1 until matrix.size) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0
                    matrix[j][0] = 0
                }
            }
        }

        // 첫 번째 열과 첫 번째 행을 이용해 행을 0으로 바꾼다.
        for(i in 1 until matrix.size) {
            if(matrix[i][0] == 0) {
                nullifyRow(matrix, i)
            }
            if(matrix[0][i] == 0) {
                nullifyCol(matrix, i)
            }
        }

        // 첫 번째 행을 0으로 바꾼다
        if (rowHasZero)
            nullifyRow(matrix, 0)
        // 첫 번째 열을 0으로 바꾼다
        if (colHasZero)
            nullifyCol(matrix, 0)
    }

    private fun nullifyRow(matrix: Array<IntArray>, row: Int) {
        for (i in 1 until matrix.size) {
            matrix[row][i] = 0
        }
    }

    private fun nullifyCol(matrix: Array<IntArray>, col: Int) {
        for (i in 1 until matrix.size) {
            matrix[i][col] = 0
        }
    }
}
