package coding_interview.problem

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MatrixUtilsTest {
    private val matrixUtils = MatrixUtils()

    @Test
    fun `should zero out rows and columns containing 0s`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 0, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 0, 15, 16)
        )

        val expectedMatrix = arrayOf(
            intArrayOf(1, 0, 0, 4),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(9, 0, 0, 12),
            intArrayOf(0, 0, 0, 0)
        )

        matrixUtils.toZeroColAndRowOf(4, matrix)
        assertArrayEquals(expectedMatrix, matrix)
    }
}