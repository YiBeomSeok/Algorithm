package inflearn.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1_4_단어_뒤집기 {

    public static List<String> solution(List<String> input) {
        List<String> answer = new ArrayList<String>();

        for(String str: input) {
            answer.add((new StringBuilder(str)).reverse().toString());
        }

        return answer;
    }

    public static List<String> solution2(List<String> input) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x : input) {
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() - 1;
            while(lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> input = new ArrayList<String>();
        for(int i = 0; i < n; i++) {
            input.add(sc.next());
        }
        for(String str: solution(input)) {
            System.out.println(str);
        }
    }
}
