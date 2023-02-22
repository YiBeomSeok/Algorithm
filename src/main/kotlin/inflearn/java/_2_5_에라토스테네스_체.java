package inflearn.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_5_에라토스테네스_체 {
    public static int solution(int n) {

        int answer = 0;
        int[] toN = new int[n + 1];
        for(int i = 2; i < toN.length; i++) {
            if(toN[i] == 0) {
                answer++;

                for(int j = i; j < toN.length; j = j + i) {
                    toN[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        System.out.print(solution(input));
    }
}
