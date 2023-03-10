package coding_interview.problem

class MatrixRotator {
    fun rotate(matrix: Array<IntArray>): Array<IntArray> {
        if(matrix.isNotEmpty())
            require(matrix.size == matrix[0].size)

        val n = matrix.size
        for(layer in 0 until n / 2) {
            val last = n - 1 - layer
            for (i in layer until last) {
                val offset = i - layer

                val top = matrix[layer][i]

                // left to top
                matrix[layer][i] = matrix[last - offset][layer]

                // bottom to left
                matrix[last - offset][layer] = matrix[last][last - offset]

                // right to bottom
                matrix[last][last - offset] = matrix[layer + offset][last]

                // top to right
                matrix[layer + offset][last] = top
            }
        }
        return matrix
    }
}