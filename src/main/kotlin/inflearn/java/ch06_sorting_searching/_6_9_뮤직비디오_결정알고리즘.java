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
        for(int i = 0;i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int right = sum(arr);
        int left = Math.min(arr[0], arr[n - 1]);

        while(left <= right) {
            int mid = (right + left) / 2;
            int sum = 0;
            int count = 1;

            for(int i = 0; i < n; i++) {
                sum += arr[i];
                if(sum > mid) {
                    count++;
                    sum = arr[i];
                }
            }

            if(count <= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for(int anInt : arr) {
            sum += anInt;
        }
        return sum;
    }
}
