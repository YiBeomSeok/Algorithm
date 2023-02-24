package programmers.skplanet;
import java.util.*;

class Solution {
    public static int[] solution(String[][] boards) {
        int[] answer = new int[boards.length];

        for (int i = 0; i < boards.length; i++) {
            String[] board = boards[i];
            int n = board.length;
            int m = board[0].length();
            int sx = -1, sy = -1;

            boolean[][][] visited = new boolean[n][m][4];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[j].charAt(k) == '2') {
                        sx = j;
                        sy = k;
                        break;
                    }
                }
            }

            dfs(board, sx, sy, visited);

            boolean canPlant = true;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[j].charAt(k) == '1' && !visited[j][k][0] && !visited[j][k][1] && !visited[j][k][2] && !visited[j][k][3]) {
                        canPlant = false;
                        break;
                    }
                }
            }

            answer[i] = canPlant ? 1 : 0;
        }

        return answer;
    }

    private static void dfs(String[] board, int x, int y, boolean[][][] visited) {
        int n = board.length;
        int m = board[0].length();

        visited[x][y][0] = true;
        visited[x][y][1] = true;
        visited[x][y][2] = true;
        visited[x][y][3] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x, ny = y;
            switch (i) {
                case 0 -> nx--;
                case 1 -> nx++;
                case 2 -> ny--;
                case 3 -> ny++;
            }
            boolean valid;
            valid = (nx >= 0)
                    && (nx < n)
                    && (ny >= 0)
                    && (ny < m)
                    && (board[nx].charAt(ny) == '1')
                    && !(visited[nx][ny][(i + 2) % 4]);

            if (valid) {
                visited[nx][ny][i] = true;
                dfs(board, nx, ny, visited);
            }
        }

        board[x] = board[x].substring(0, y) + '1' + board[x].substring(y + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] boards = {
                {"00011", "01111", "21001", "11001", "01111"},
                {"00011", "00011", "11111", "12101", "11111"}
        };
        int[] expected = {1, 1};

        int[] ans = solution(boards);
        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}

