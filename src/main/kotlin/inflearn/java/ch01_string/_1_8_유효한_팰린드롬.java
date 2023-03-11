package inflearn.java.ch01_string;

import java.util.Scanner;

public class _1_8_유효한_팰린드롬 {

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(Character.isAlphabetic(str.charAt(i)))
                sb.append(str.charAt(i));
        }
        String origin = sb.toString();
        String reverse = sb.reverse().toString();

        if(origin.equalsIgnoreCase(reverse)) return "YES";
        else return "NO";
    }

    /**
     * 정규식을 활용하는 방법
     * ^ -> 아닌 것들
     * [^A-Z] -> A부터 Z 까지가 아닌 것들
     * @param s
     * @return
     */
    public static String solution2(String s) {
        s = s.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(s).reverse().toString();
        if(s.equals(tmp))
            return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(solution(input));
    }
}
