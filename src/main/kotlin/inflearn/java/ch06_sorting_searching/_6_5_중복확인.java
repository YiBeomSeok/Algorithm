package inflearn.java.ch06_sorting_searching;

import java.io.*;
import java.util.*;

public class _6_5_중복확인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (isDuplicate(n, arr))
            System.out.println("D");
        else
            System.out.println("U");
    }

    public static boolean isDuplicate(int n, int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int anInt : arr) {
            hashSet.add(anInt);
        }

        return hashSet.size() != n;
    }
}
