import java.io.*;
import java.util.*;

class Dice {
    int[] face = new int[7];
    int dir, x, y;
    int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};   // 동 서 북 남, dir = cmd - 1 해주면 된다.

    public Dice(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int cmd) {
        dir = cmd - 1;

        x += dx[dir];
        y += dy[dir];

        if(dir == 0) {
            //    6 4 1 3 6
            // -> 3 6 4 1 3
            int temp = face[1];
            face[1] = face[4];
            face[4] = face[6];
            face[6] = face[3];
            face[3] = temp;

        } else if(dir == 1) {
            //    6 4 1 3 6
            // -> 4 1 3 6 4
            int temp = face[1];
            face[1] = face[3];
            face[3] = face[6];
            face[6] = face[4];
            face[4] = temp;

        } else if(dir == 2) {
            //    6 2 1 5 6
            // -> 2 1 5 6 2
            int temp = face[1];
            face[1] = face[5];
            face[5] = face[6];
            face[6] = face[2];
            face[2] = temp;

        } else if(dir == 3) {
            // 6 2 1 5 6
            // 5 6 2 1 5
            int temp = face[1];
            face[1] = face[2];
            face[2] = face[6];
            face[6] = face[5];
            face[5] = temp;

        }
    }
}
public class Main{

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int[] cmd;
    public static int[][] map;
    public static int r, c, x, y, N, M, K;
    public static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cmd = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            cmd[i] = Integer.parseInt(st.nextToken());
        }
        // 입력 완료

        Dice dice = new Dice(x, y);
        for(int i = 0; i < K; i++) {
            int dir = cmd[i] - 1;
            int nx = dice.x + dx[dir], ny = dice.y + dy[dir];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            dice.move(cmd[i]);

            if(map[nx][ny] == 0) {
                map[nx][ny] = dice.face[6];
            } else {
                dice.face[6] = map[nx][ny];
                map[nx][ny] = 0;
            }

            sb.append(dice.face[1]).append("\n");
        }

        System.out.print(sb);
    }
}