package coding_interview.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _1_5Test {

    @Test
    void testEmptyStrings() {
        assertTrue(_1_5_EditDistanceChecker.checkIfOneEditAway("", ""));
    }

    @Test
    void testEmptyAndNonEmptyString() {
        assertTrue(_1_5_EditDistanceChecker.checkIfOneEditAway("a", ""));
        assertTrue(_1_5_EditDistanceChecker.checkIfOneEditAway("", "a"));
    }

    @Test
    void testEqualStrings() {
        assertTrue(_1_5_EditDistanceChecker.checkIfOneEditAway("abc", "abc"));
    }

    @Test
    void testInsertCharacter() {
        assertTrue(_1_5_EditDistanceChecker.checkIfOneEditAway("ab", "abc"));
        assertTrue(_1_5_EditDistanceChecker.checkIfOneEditAway("abc", "ab"));
    }

    @Test
    void testRemoveCharacter() {
        assertTrue(_1_5_EditDistanceChecker.checkIfOneEditAway("abc", "ac"));
        assertTrue(_1_5_EditDistanceChecker.checkIfOneEditAway("ac", "abc"));
    }

    @Test
    void testReplaceCharacter() {
        assertTrue(_1_5_EditDistanceChecker.checkIfOneEditAway("abc", "bbc"));
        assertTrue(_1_5_EditDistanceChecker.checkIfOneEditAway("bbc", "abc"));
    }

    @Test
    void testMoreThanOneEdit() {
        assertFalse(_1_5_EditDistanceChecker.checkIfOneEditAway("abc", "acbd"));
    }

    @Test
    void testDifferentLengths() {
        assertFalse(_1_5_EditDistanceChecker.checkIfOneEditAway("abcd", "ab"));
        assertFalse(_1_5_EditDistanceChecker.checkIfOneEditAway("ab", "abcd"));
    }
}