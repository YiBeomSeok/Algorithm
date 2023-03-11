package inflearn.java.ch02_array;

import java.util.*;
import java.io.*;
public class _2_12_멘토링 {
    public static int solution(int n, int m, int[][] input) {
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int student = input[0][i];
            HashSet<Integer> mentee = new HashSet<>();

            for(int j = i + 1; j < n; j++) {
                mentee.add(input[0][j]);
            }

            for(int j = 0; j < m; j++) {
                for(int k = 0; k < n; k++) {
                    if(input[j][k] == student) break;
                    mentee.remove(input[j][k]);
                }
            }
            answer += mentee.size();
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st. nextToken());

        int[][] input = new int[m][n];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, m, input));
    }
}
