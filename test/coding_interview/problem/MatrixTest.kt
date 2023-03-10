package coding_interview.problem

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MatrixTest {
    private val rotator = MatrixRotator()

    @Test
    fun testRotateEmptyMatrix() {
        val input = arrayOf<IntArray>()
        val expectedOutput = arrayOf<IntArray>()
        assertArrayEquals(expectedOutput, rotator.rotate(input))
    }

    @Test
    fun testRotateOneByOneMatrix() {
        val input = arrayOf(intArrayOf(1))
        val expectedOutput = arrayOf(intArrayOf(1))
        assertArrayEquals(expectedOutput, rotator.rotate(input))
    }

    @Test
    fun testRotateTwoByTwoMatrix() {
        val input = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        val expectedOutput = arrayOf(intArrayOf(3, 1), intArrayOf(4, 2))
        assertArrayEquals(expectedOutput, rotator.rotate(input))
    }

    /**
     * 1 2 3  7 4 1
     * 4 5 6  8 5 2
     * 7 8 9  9 6 3
     */
    @Test
    fun testRotateThreeByThreeMatrix() {
        val input = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        val expectedOutput = arrayOf(intArrayOf(7, 4, 1), intArrayOf(8, 5, 2), intArrayOf(9, 6, 3))
        assertArrayEquals(expectedOutput, rotator.rotate(input))
    }

    @Test
    fun testRotateFourByFourMatrix() {
        val input = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12), intArrayOf(13, 14, 15, 16))
        val expectedOutput = arrayOf(intArrayOf(13, 9, 5, 1), intArrayOf(14, 10, 6, 2), intArrayOf(15, 11, 7, 3), intArrayOf(16, 12, 8, 4))
        assertArrayEquals(expectedOutput, rotator.rotate(input))
    }
}