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
        Queue<Patient> patients = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            Patient patient = new Patient(i, risk[i]);
            patients.offer(patient);
        }

        int count = 0;
        while(!patients.isEmpty()) {
            Patient patient = patients.poll();
            if(hasMoreLisk(patient, patients)) {
                patients.offer(patient);
            } else {
                count++;
                if(patient.id == m) return count;
            }
        }
        return count;
    }

    private static boolean hasMoreLisk(Patient patient, Queue<Patient> patients) {
        for(Patient p : patients) {
            if(p.risk > patient.risk) return true;
        }
        return false;
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