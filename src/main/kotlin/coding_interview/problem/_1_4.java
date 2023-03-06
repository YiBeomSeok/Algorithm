package coding_interview.problem;

import java.util.*;

public class _1_4 {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact Coa"));
    }

    public static boolean isPalindromePermutation(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        String str = input.toLowerCase();
        for(char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int oddCount = 0;
        map.remove(' ');
        for(char ch : map.keySet()) {
            if(map.get(ch) % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}
