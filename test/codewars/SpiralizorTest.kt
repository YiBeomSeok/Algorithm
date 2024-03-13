package codewars

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SpiralizorTest {

    @Test
    fun testSpiralizeLargeMatrix() {
        val expected = arrayOf(
            byteArrayOf(1, 1, 1, 1, 1),
            byteArrayOf(0, 0, 0, 0, 1),
            byteArrayOf(1, 1, 1, 0, 1),
            byteArrayOf(1, 0, 0, 0, 1),
            byteArrayOf(1, 1, 1, 1, 1)
        )
        assertArrayEquals(expected, Spiralizor.spiralize(5, 5))
    }

    @Test
    fun testSpiralizeLargeMatrix7x7() {
        val expected = arrayOf(
            byteArrayOf(1, 1, 1, 1, 1, 1, 1),
            byteArrayOf(0, 0, 0, 0, 0, 0, 1),
            byteArrayOf(1, 1, 1, 1, 1, 0, 1),
            byteArrayOf(1, 0, 0, 0, 1, 0, 1),
            byteArrayOf(1, 0, 1, 1, 1, 0, 1),
            byteArrayOf(1, 0, 0, 0, 0, 0, 1),
            byteArrayOf(1, 1, 1, 1, 1, 1, 1)
        )
        assertArrayEquals(expected, Spiralizor.spiralize(7, 7))
    }

    @Test
    fun testSpiralizeMatrix7x9() {
        val expected = arrayOf(
            byteArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1),
            byteArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1),
            byteArrayOf(1, 1, 1, 1, 1, 1, 1, 0, 1),
            byteArrayOf(1, 0, 0, 0, 0, 0, 1, 0, 1),
            byteArrayOf(1, 0, 1, 1, 1, 1, 1, 0, 1),
            byteArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 1),
            byteArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1)
        )
        assertArrayEquals(expected, Spiralizor.spiralize(7, 9))
    }
}

object Spiralizor {
    fun spiralize(n: Int): Array<ByteArray> {
        val map = Array(n) { ByteArray(n) { 0 } }

        var i = n
        var j = 0

        while (i > j) {
            if (j > 0) map[j][j - 1] = 1
            for (a in j until i) {
                map[j][a] = 1
            }
            for (a in j until i) {
                map[a][i - 1] = 1
            }
            for (a in i - 1 downTo j + 1) {
                map[i - 1][a] = 1
            }
            for (a in i - 1 downTo j + 2) {
                map[a][j] = 1
            }
            i -= 2
            j += 2
        }
        return map
    }

    fun spiralize(n: Int, m: Int): Array<ByteArray> {
        val map = Array(n) { ByteArray(m) { 0 } }

        var ni = n
        var mi = m
        var nj = 0
        var mj = 0

        while ((nj < ni) && (mj < mi)) {
            if (mj > 0) map[nj][mj - 1] = 1

            for (a in mj until mi) {
                map[mj][a] = 1
            }
            for (a in nj until ni) {
                map[a][mi - 1] = 1
            }
            for (a in mi - 1 downTo mj + 1) {
                map[ni - 1][a] = 1
            }
            for (a in ni - 1 downTo nj + 2) {
                map[a][mj] = 1
            }

            ni -= 2
            mi -= 2
            nj += 2
            mj += 2
        }
        return map
    }
}