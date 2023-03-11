package inflearn.java.ch02_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2_7_점수계산 {
    public static int solution(int[] input) {

        int answer = 0;
        int bonus = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] == 1) {
                answer = answer + 1 + bonus;
                bonus += 1;
            }
            else
                bonus = 0;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(input));
    }
}
