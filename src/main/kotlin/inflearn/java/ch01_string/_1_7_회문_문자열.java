package inflearn.java.ch01_string;

import java.util.Scanner;

public class _1_7_회문_문자열 {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        if(sb.toString().equalsIgnoreCase(str))
            return "YES";
        else
            return  "NO";
    }

    public static String solution2(String str) {
        int len = str.length();
        str = str.toUpperCase();
        for(int i = 0; i < len/2; i++) {
            if(str.charAt(i) != str.charAt(len - i - 1))
                return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solution(input));
    }
}
