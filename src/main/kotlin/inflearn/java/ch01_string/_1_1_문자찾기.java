package inflearn.java.ch01_string;

import java.util.Scanner;

public class _1_1_문자찾기 {
    public static int solution(String str, char t) {
        int answer = 0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for(char ch: str.toCharArray()) {
            if(ch == t)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);

        System.out.print(solution(str, c));
    }
}
