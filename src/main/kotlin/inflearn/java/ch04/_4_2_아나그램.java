package inflearn.java.ch04;

import java.io.*;
import java.util.*;

public class _4_2_아나그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        if (solution(s1, s2))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    /**
     * O(NlogN)을 두 번 하게된다.
     *
     * @param s1 문자열 1번
     * @param s2 문자열 2번
     * @return s1과 s2가 아나그램인지 아닌지
     */
    public static boolean solution(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        return Arrays.equals(s1Array, s2Array);
    }

    /**
     * O(N) 시간복잡도로 실행된다.
     *
     * @param s1 문자열 1번
     * @param s2 문자열 2번
     * @return s1과 s2가 아나그램인지 아닌지
     */
    public static boolean moreEfficientSolution(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            int freq = map.getOrDefault(c, 0);
            if (freq == 0) return false;
            map.put(c, freq - 1);
        }
        return true;
    }
}
