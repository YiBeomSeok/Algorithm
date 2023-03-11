package inflearn.java.ch06_sorting_searching;

import java.io.*;
import java.util.*;

public class _6_1_선택_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder(n * 2);
        for(int anInt : solution(n, ints)) {
            sb.append(anInt).append(" ");
        }

        System.out.println(sb);
    }

    public static int[] solution(int n, int[] integers) {
        for(int i = 0; i < n; i++) {
            int minIndex = i;
            for(int j = i + 1; j < n; j++) {
                if(integers[j] < integers[minIndex]) minIndex = j;
            }
            int tmp = integers[i];
            integers[i] = integers[minIndex];
            integers[minIndex] = tmp;
        }

        return integers;
    }
}
