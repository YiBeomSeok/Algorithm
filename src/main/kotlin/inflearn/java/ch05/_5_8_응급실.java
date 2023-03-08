package inflearn.java.ch05;

import java.io.*;
import java.util.*;

public class _5_8_응급실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] risk = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            risk[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(n, m, risk));
    }

    public static int solution(int n, int m, int[] risk) {
        int answer = 0;
        Queue<Patient> pQueue = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            pQueue.offer(new Patient(i, risk[i]));
        }

        while(!pQueue.isEmpty()) {
            Patient tmp = pQueue.poll();
            for(Patient x : pQueue) {
                if(x.risk > tmp.risk) {
                    pQueue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                answer++;
                if(tmp.id == m) return answer;
            }
        }
        return answer;
    }
}

class Patient {
    int id;
    int risk;

    public Patient(int id, int risk) {
        this.id = id;
        this.risk = risk;
    }
}