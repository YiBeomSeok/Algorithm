package inflearn.java.ch01_string;

import java.util.Scanner;

public class _1_9_숫자만_추출 {
    public static Integer solution(String s) {
        String str = s.replaceAll("[^0-9]","");
        return Integer.parseInt(str);
    }

    public static Integer solution2(String s) {
        StringBuilder answer = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) answer.append(ch);
        }
        return Integer.parseInt(answer.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(solution(input));
    }
}
