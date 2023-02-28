package inflearn.java;

import java.io.*;
import java.util.*;

public class _3_2_공통원소_구하기 {
    public static ArrayList<Integer> solution(int n, int m, int[] nArr, int[] mArr) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashSet<Integer> hashSetN = new HashSet<>();
        for(int i = 0; i < n; i++) {
            hashSetN.add(nArr[i]);
        }
        for(int i = 0; i < m; i++) {
            if(hashSetN.contains(mArr[i]))
                answer.add(mArr[i]);
        }
        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        int[] nArr, mArr;

        n = Integer.parseInt(br.readLine());
        nArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        mArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> answer = solution(n, m, nArr, mArr);

        for(int elem : answer) {
            System.out.print(elem + " ");
        }
    }
}
