import java.util.*;
import java.io.*;

class Marble {
    int rx, ry;
    int bx, by;
    int cnt;

    public Marble (int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}

/**
 * Tip
 * 2차원 배열을 회전시켜서(-90도) 생각해보면 
 * 배열의 1차원을 x로 둘 수 있다. 즉 map[0][1]이면 x=0, y=1이다. 
 */
public class Main {
    public static int N, M;
    public static char[][] map;
    public static boolean[][][][] visited;
    public static int holeX, holeY;
    public static Marble blue, red;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                } else if (map[i][j] == 'B') {
                    blue = new Marble(0, 0, i, j, 0);
                } else if (map[i][j] == 'R') {
                    red = new Marble(i, j, 0, 0, 0);
                }
            }
        }

        System.out.print(bfs());

        br.close();
    }

    public static int bfs() {
        Queue<Marble> queue = new ArrayDeque<>();
        queue.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.bx][blue.by] = true;

        while(!queue.isEmpty()) {
            Marble marble = queue.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            if(curCnt > 10) return -1;

            for(int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while(map[newRx + dx[i]][newRy + dy[i]] != '#') {
                    newRx += dx[i];
                    newRy += dy[i];

                    if(newRx == holeX && newRy == holeY) {
                        isRedHole = true;
                        break;
                    }
                }

                while(map[newBx + dx[i]][newBy + dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];

                    if(newBx == holeX && newBy == holeY) {
                        isBlueHole = true;
                        break;
                    }
                }

                // 너비우선탐색이므로 red만 홀에 들어간 경우 그 상황이 최소값이다.
                if(isBlueHole) continue;
                else if(isRedHole) {
                    return curCnt;
                }

                // 이동 중에 따지는 것 보다 다 이동시키고 다시 조정해주는 것이 낫다.
                if(newRx == newBx && newRy == newBy) {
                    if(i == 0) { // 위쪽으로 기울이기
                        // 더 큰 x값을 가지는 구슬이 뒤로 감
                        if(curRx > curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else if(i == 1) { // 오른쪽으로 기울이기
                        // 더 작은 y값을 가지는 구슬이 뒤로 감
                        if(curRy < curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    } else if(i == 2) { // 아래쪽으로 기울이기
                        // 더 작은 x값을 가지는 구슬이 뒤로 감
                        if(curRx < curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else { // 왼쪽으로 기울이기
                        // 더 큰 y값을 가지는 구슬이 뒤로 감
                        if(curRy > curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                }

                // 두 구슬이 이동할 위치가 처음 방문하는 곳인 경우만 이동 -> 큐에 추가
                if(!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    queue.add(new Marble(newRx, newRy, newBx, newBy, curCnt+1));
                }
            }
        }

        return -1;
    }
}