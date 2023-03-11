package inflearn.java.ch06_sorting_searching;

import java.io.*;
import java.util.*;

public class _6_6_장난꾸리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int number : solution(n, heights)) {
            System.out.print(number + " ");
        }
    }

    public static int[] solution(int n, int[] heights) {
        int[] answer = new int[2];
        int[] tmp = heights.clone();
        Arrays.sort(tmp);
        int next = 0;
        for(int i = 0; i < n; i++) {
            if(heights[i] != tmp[i]) answer[next++] = i + 1;
        }

        return answer;
    }
}
