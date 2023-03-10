package coding_interview.problem;

import java.io.*;

public class _1_5_EditDistanceChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(checkIfOneEditAway(s1, s2));
    }

    /**
     * Checks if two strings are one edit (or zero edits) away.
     * An edit is defined as one of the following operations:
     * 1. Inserting a character
     * 2. Removing a character
     * 3. Replacing a character
     *
     * @param str1 the first string
     * @param str2 the second string
     * @return true if the two strings are one edit (or zero) away, otherwise false
     */
    public static boolean checkIfOneEditAway(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (Math.abs(len1 - len2) > 1)
            return false;

        String longer = len1 >= len2 ? str1 : str2;
        String shorter = len1 < len2 ? str1 : str2;

        int edit = 0;
        for (int i = 0, j = 0; i < longer.length() && j < shorter.length(); i++, j++) {
            if (longer.charAt(i) != shorter.charAt(j)) {
                edit++;
                if (edit > 1) {
                    return false;
                }
                if (len1 != len2) {
                    i++;
                }
            }
        }

        return true;
    }
}
