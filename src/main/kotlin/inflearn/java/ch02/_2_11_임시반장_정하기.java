package inflearn.java.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2_11_임시반장_정하기 {
    public static int solution(int n, int[][] inputs) {
        int max = Integer.MIN_VALUE;
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= 5; k++) {
                    if(inputs[i][k] == inputs[j][k]) {
                        sum++;
                        break;
                    }
                }
            }
            if(sum > max) {
                max = sum;
                answer = i;
            }
        }
        return answer;
    }

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] inputs = new int[n + 1][6];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < 6; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(n, inputs);
        System.out.print(result);
    }
}