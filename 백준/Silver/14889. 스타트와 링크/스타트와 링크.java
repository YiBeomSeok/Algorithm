import java.util.*;
public class Main {

    static int N;
    static boolean check[] = new boolean[21];
    static int ability[][] = new int[21][21];
    static int ans = 1000000000;


    public static void DFS(int idx, int n) {

        if(n == N/2) {
            int start = 0;
            int link = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(check[i] && check[j]) start += ability[i][j];
                    if(!check[i] && !check[j]) link += ability[i][j];
                }
            }

            ans = Math.min(Math.abs(start-link),ans);

            return;
        }

        for (int i = idx; i <= N; i++) {
            if(!check[i]) {
                check[i] = true;
                DFS(i+1,n+1);
                check[i] = false;
            }
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ability[i][j] = sc.nextInt();
            }
        }

        DFS(1,0);

        System.out.println(ans);
    }
}