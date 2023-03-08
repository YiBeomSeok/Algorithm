package inflearn.java.ch03;

import java.io.*;
import java.util.*;

public class _3_1_두_배열_합치기 {
    public static int[] solution(int n, int m, int[] arr1, int[] arr2) {
        int[] answer = new int[n + m];
        int ai = 0, ni = 0, mi = 0;
        while(ni < n && mi < m) {
            int min = Math.min(arr1[ni], arr2[mi]);
            answer[ai] = min;
            ai++;
            if(min == arr1[ni])
                ni++;
            else
                mi++;
        }
        for(int i = ni; i < n; i++, ai++) {
            answer[ai] = arr1[i];
        }

        for(int i = mi; i < m; i++, ai++) {
            answer[ai] = arr2[i];
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n, m;
        int[] arr1, arr2;

        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = solution(n, m, arr1, arr2);
        for (int j : answer) {
            System.out.print(j + " ");
        }
    }
}
