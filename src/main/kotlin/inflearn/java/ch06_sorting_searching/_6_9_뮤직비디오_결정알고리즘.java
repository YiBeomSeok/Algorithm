package inflearn.java.ch06_sorting_searching;

import java.io.*;
import java.util.*;

public class _6_9_뮤직비디오_결정알고리즘 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;

        int left = min(n, arr);
        int right = sum(n, arr);

        while(left <= right) {
            int sum = 0;
            int count = 1;
            int mid = (left + right) / 2;

            for(int i = 0; i < n; i++) {
                if(sum + arr[i] > mid) {
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }

            if(count <= m) {
                answer = mid;
                right -= 1;
            } else {
                // count > m
                left += 1;
            }
        }
        return answer;
    }

    public static int sum(int n, int[] arr) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static int min(int n, int[] arr) {
        int min = arr[0];
        for(int i = 1; i < n; i++) {
            if(min > arr[i]) min = arr[i];
        }
        return min;
    }
}
