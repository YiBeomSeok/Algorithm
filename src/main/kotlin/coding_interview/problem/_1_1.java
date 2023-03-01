package coding_interview.problem;

import java.util.*;

public class _1_1 {
    public static boolean hasDuplicatedChar1(String str) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set.size() != str.length();
    }

    public static boolean hasDuplicatedChar2(String str) {
        return str.length() > 1 && str.chars().distinct().count() < str.length();
    }

    public static void main(String[] args) {

    }
}
