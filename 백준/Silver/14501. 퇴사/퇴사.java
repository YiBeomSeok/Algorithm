import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int num = Integer.parseInt(br.readLine());

        int t[] = new int[num + 15];
        int p[] = new int[num + 15];
        int dp[] = new int[num + 15];
        int max = 0;

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= num; i++) {
            dp[i] = Math.max(dp[i], max);

            dp[t[i] + i] = Math.max(dp[t[i] + i], p[i] + dp[i]);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}