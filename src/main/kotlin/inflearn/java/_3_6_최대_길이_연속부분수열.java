package inflearn.java;

import java.io.*;
import java.util.*;

public class _3_6_최대_길이_연속부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, k;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] intArray = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, intArray));
    }

    public static int trash(int n, int k, int[] intArray) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (intArray[i] == 0) {
                q.add(i);
                intArray[i] = 1;
            }
            if (q.size() == k) {
                int st = q.remove();
                int len = 0;
                for (int j = st; j >= 0; j--) {
                    if (intArray[j] == 0) break;
                    len++;
                }
                for (int j = st + 1; j < n; j++) {
                    if (intArray[j] == 0) break;
                    len++;
                }
                if(len > answer) answer = len;
                intArray[st] = 0;
            }
        }
        return answer;
    }

    public static int solution(int n, int k, int[] intArray) {
        int answer = 0, cnt = 0, lt = 0;
        for(int rt = 0; rt < n; rt++) {
            if(intArray[rt] == 0) cnt++;
            while(cnt > k) {
                if(intArray[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }
}
