package inflearn.java.ch05;

import java.util.*;
import java.io.*;

public class _5_6_공주_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, k;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            deque.addLast(i + 1);
        }

        int count = 0;
        while(deque.size() > 1) {
            count = (count + 1) % k;
            int now = deque.removeFirst();
            if(count == 0) continue;

            deque.addLast(now);
        }

        return deque.remove();
    }
}
