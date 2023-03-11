package inflearn.java.ch03_twopointer_slidingwindow;

import java.io.*;
import java.util.*;

public class _3_3_최대_매출 {
    public static int solution(int n, int k, int[] sales) {
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < k; i++)
            currentSum += sales[i];

        maxSum = currentSum;

        for (int i = k; i < n; i++) {
            currentSum += sales[i] - sales[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] sales = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sales[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, sales));
    }
}
