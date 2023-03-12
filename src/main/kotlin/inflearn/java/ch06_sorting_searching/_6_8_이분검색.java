package inflearn.java.ch06_sorting_searching;

import java.util.*;
import java.io.*;

public class _6_8_이분검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int mid = (right + left) / 2;

            if(m >= arr[mid]) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer + 1;
    }
}
