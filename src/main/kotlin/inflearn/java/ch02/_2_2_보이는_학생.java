package inflearn.java.ch02;

import java.util.Scanner;
import java.util.StringTokenizer;

public class _2_2_보이는_학생 {
    public static int solution(int[] ints) {
        int prev = Integer.MIN_VALUE;

        int answer = 0;
        for (int cm : ints) {
            if(cm > prev) {
                answer++;
                prev = cm;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(ints));
    }
}
