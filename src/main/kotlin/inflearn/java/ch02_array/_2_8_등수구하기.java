package inflearn.java.ch02_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2_8_등수구하기 {
    public static List<Integer> solution(int[] scores) {
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < scores.length; i++) {
            int rating = 1;
            for(int j = 0; j < scores.length; j++) {
                if(scores[j] > scores[i]) rating++;
            }
            answer.add(rating);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] students = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> sol = solution(students);

        for(int rating : sol) {
            System.out.print(rating + " ");
        }
    }
}
