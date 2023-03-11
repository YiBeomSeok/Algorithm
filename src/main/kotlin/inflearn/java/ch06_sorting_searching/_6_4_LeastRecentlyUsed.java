package inflearn.java.ch06_sorting_searching;

import java.io.*;
import java.util.*;

public class _6_4_LeastRecentlyUsed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s, n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] jobSchedule = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            jobSchedule[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder(s * 2);
        for (int job : solution(s, n, jobSchedule)) {
            sb.append(job).append(" ");
        }

        System.out.println(sb);
    }

    public static int[] solution(int s, int n, int[] jobSchedule) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            int job = jobSchedule[i];
            if(deque.contains(job)) {
                deque.remove(job);
                deque.offerFirst(job);
            } else {
                deque.offerFirst(job);
                if(deque.size() > s)
                    deque.pollLast();
            }
        }

        int[] answer = new int[s];
        int i = 0;
        for(int job : deque) {
            answer[i++] = job;
        }
        return answer;
    }
}
