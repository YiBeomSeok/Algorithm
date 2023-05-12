import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] applicants = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i = 0; i < split.length; i++) {
            applicants[i] = Integer.parseInt(split[i]);
        }
        split = br.readLine().split(" ");
        var B = Integer.parseInt(split[0]);
        var C = Integer.parseInt(split[1]);

        var answer = 0L;

        for(int i = 0; i < N; i++) {
            answer += 1;
            int remain = applicants[i] - B;
            if(remain > 0) {
                answer += remain / C;
                if(remain % C != 0) {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}