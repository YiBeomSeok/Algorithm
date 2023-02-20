package inflearn.java;

import java.util.Scanner;

public class _1_11_문자열_압축 {
    public static String solutionTRESH(String str) {
        StringBuilder answer = new StringBuilder();

        int p = 0;
        char prev = '\0';
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == prev)
                p++;
            if (now != prev || i == str.length() - 1) {
                if (prev != '\0')
                    answer.append(prev);
                if (p > 1)
                    answer.append(p);
                prev = now;
                p = 1;
            }
        }

        return answer.toString();
    }

    public static String solution(String str) {
        str = str + '\0';
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1))
                cnt++;
            else {
                sb.append(str.charAt(i));
                if(cnt > 1)
                    sb.append(cnt);
                cnt = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solution(input));
    }
}
