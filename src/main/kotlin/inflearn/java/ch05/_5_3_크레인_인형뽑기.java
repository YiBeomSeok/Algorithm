package inflearn.java.ch05;

import java.io.*;
import java.util.*;

public class _5_3_크레인_인형뽑기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board.length;
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            int grepCol = move - 1;

            for (int raw = 0; raw < len; raw++) {
                int dol = board[raw][grepCol];

                if (dol != 0) {
                    board[raw][grepCol] = 0;

                    if (basket.size() > 0 && basket.peek() == dol) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(dol);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
