package inflearn.java.ch04_hashmap_treeset;

import java.io.*;
import java.util.*;

public class _4_5_K번째_큰_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, k;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Integer[] intArray = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, intArray));
    }

    public static int solution(int n, int k, Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        SortedSet<Integer> sortedSet = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int l = j + 1; l < n; l++) {
                    int now = arr[i] + arr[j] + arr[l];
                    sortedSet.add(now);
                }
            }
        }
        int cnt = 0;
        for(int x: sortedSet) {
            cnt++;
            if(cnt == k) return x;
        }
        return -1;
    }
}

// 10 3
// 13 15 34 23 45 65 33 11 26 42
// 65 45 42 34 33 26 23 15 13 11
// 65 + 45 = 110, 110 + 42 = 152
// 65 + 45 = 110, 110 + 34 = 144
// 65 + 45 = 110, 110 + 33 = 143
// 65 + 42 = 107, 107 + 34 = 141