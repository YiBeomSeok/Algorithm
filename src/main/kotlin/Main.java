import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] input = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Long.parseLong(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (long aLong : solution(n, input)) {
            sb.append(aLong).append(" ");
        }
        System.out.print(sb);
    }

    public static long[] solution(int n, long[] longArray) {
        Stack<Long> stack = new Stack<>();
        long[] result = new long[n];
        Arrays.fill(result, -1);
        for (int i = longArray.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(longArray[i]);
            } else {
                long top = stack.peek();

                if (longArray[i] >= top) {
                    while (!stack.isEmpty()) {
                        long nextLast = stack.pop();
                        if (longArray[i] < nextLast) {
                            result[i] = nextLast;
                        }
                    }
                    stack.push(longArray[i]);

                } else {
                    result[i] = top;
                    stack.push(longArray[i]);
                }
            }
        }
        return result;
    }
}