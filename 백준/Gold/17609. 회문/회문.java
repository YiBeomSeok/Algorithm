import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }

        int[] result = solution(n, strings);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n, String[] strings) {
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            String currentStr = strings[i];
            int length = currentStr.length();
            int c1 = -1, c2 = -1;

            for (int j = 0; j < length / 2; j++) {
                if (currentStr.charAt(j) != currentStr.charAt(length - j - 1)) {
                    c1 = j;
                    c2 = length - j - 1;
                    break;
                }
            }

            if (c1 == -1) {
                answer[i] = 0;
                continue;
            }

            String copy1 = currentStr.substring(0, c1) + currentStr.substring(c1 + 1);
            if (isPalindrome(copy1)) {
                answer[i] = 1;
                continue;
            }

            String copy2 = currentStr.substring(0, c2) + currentStr.substring(c2 + 1);
            if (isPalindrome(copy2)) {
                answer[i] = 1;
                continue;
            }

            answer[i] = 2;
        }

        return answer;
    }

    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
