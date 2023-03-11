package inflearn.java.ch01_string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _1_10_가장_짧은_문자거리 {
    public static int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        int p = 1000;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p += 1;
            }
            answer[i] = p;
        }
        p = 1000;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p += 1;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }

    public static String solutionTRESH(String s, char t) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, Integer.MAX_VALUE);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == t) {
                    memo[i] = j - i;
                    break;
                }
            }
            for (int j = i; j >= 0; j--) {
                if (s.charAt(j) == t) {
                    if (memo[i] < i - j)
                        break;
                    memo[i] = i - j;
                    break;
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int dis : memo) {
            answer.append(dis).append(" ");
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int anInt : solution(st.nextToken(), st.nextToken().charAt(0))) {
            System.out.print(anInt);
            System.out.print(" ");
        }
    }
}
