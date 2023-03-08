package inflearn.java.ch04;

import java.io.*;
import java.util.*;

public class _4_3_매출액의_종류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, k;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr = solution(n, k, arr);
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static int[] solution(int n, int k, int[] arr) {

        int lt = 0, rt;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (rt = 0; rt < n; rt++) {
            int rightNum = arr[rt];
            counts.put(rightNum, counts.getOrDefault(rightNum, 0) + 1);
            if (rt - lt + 1 == k) {
                result.add(counts.size());

                int leftNum = arr[lt];
                counts.put(arr[lt], counts.get(leftNum) - 1);
                if (counts.get(leftNum) == 0)
                    counts.remove(leftNum);
                lt++;
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
