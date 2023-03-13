package inflearn.java.ch06_sorting_searching;

import java.io.*;
import java.util.*;

public class _6_10_마구간_정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n, c;
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, c, arr));
    }

    public static int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int rt = arr[n - 1] - arr[0];
        int lt = 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (count(arr, mid) >= c) {
                lt = mid + 1;
                answer = mid;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public static int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }
}