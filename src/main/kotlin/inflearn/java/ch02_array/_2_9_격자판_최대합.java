package inflearn.java.ch02_array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class _2_9_격자판_최대합 {
    public static int solution(int[][] ints) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        int n = ints.length;
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += ints[i][j];
                sum2 += ints[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += ints[i][i];
            sum2 += ints[i][n - 1 - i];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] input = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(input));
    }
}
