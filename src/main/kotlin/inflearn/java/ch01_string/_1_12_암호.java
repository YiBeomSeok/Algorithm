package inflearn.java.ch01_string;

import java.util.Scanner;

public class _1_12_암호 {
    public static String solution(int n, String s) {
        StringBuilder answer = new StringBuilder();
        s = s.replace('#', '1');
        s = s.replace('*', '0');

        while (s.length() > 0) {
            String now = s.substring(0, 7);
            s = s.substring(7);
            char ch = (char) (Integer.parseInt(now, 2));
            answer.append(ch);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        String s = sc.next();
        System.out.println(solution(n, s));
    }
}
