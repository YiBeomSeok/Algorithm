package inflearn.java.ch03_twopointer_slidingwindow;

import java.io.*;
import java.util.*;

public class _3_4_연속_부분수열 {
    public static int trash(int n, int m, int[] intArray) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += intArray[j];
                if (sum == m) {
                    answer++;
                    break;
                } else if (sum > m) break;
            }
        }
        return answer;
    }

    public static int solution(int n, int m, int[] intArray) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        for(int rt = 0; rt < n; rt++) {
            sum += intArray[rt];
            if(sum == m) answer++;
            while(sum >= m) {
                sum -= intArray[lt++];
                if(sum == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] intArray = new int[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, intArray));
    }
}
