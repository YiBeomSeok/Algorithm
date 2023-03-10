package coding_interview.problem

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class StringContractionCheckerTest {
    private val checker = StringContractionChecker()

    @Test
    fun testNoConsecutiveRepeatingCharacters() {
        val input = "abcdefg"
        val expectedOutput = "abcdefg"
        assertEquals(expectedOutput, checker.contractString(input))
    }

    @Test
    fun testAllCharactersRepeatingConsecutively() {
        val input = "11111111"
        val expectedOutput = "18"
        assertEquals(expectedOutput, checker.contractString(input))
    }

    @Test
    fun testSomeCharactersRepeatingConsecutively() {
        val input = "aabbccdd"
        val expectedOutput = "a2b2c2d2"
        assertEquals(expectedOutput, checker.contractString(input))
    }

    @Test
    fun testSingleCharacter() {
        val input = "a"
        val expectedOutput = "a"
        assertEquals(expectedOutput, checker.contractString(input))
    }

    @Test
    fun testEmptyString() {
        val input = ""
        val expectedOutput = ""
        assertEquals(expectedOutput, checker.contractString(input))
    }
}