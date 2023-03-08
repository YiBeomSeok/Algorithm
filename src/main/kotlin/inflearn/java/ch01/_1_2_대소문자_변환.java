package inflearn.java.ch01;

import java.util.Scanner;

public class _1_2_대소문자_변환 {

    public static String solution(String str) {
        StringBuilder answer = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if(Character.isLowerCase(ch))
                answer.append(Character.toUpperCase(ch));
            else
                answer.append(Character.toLowerCase(ch));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        System.out.println(solution(input));
    }
}
