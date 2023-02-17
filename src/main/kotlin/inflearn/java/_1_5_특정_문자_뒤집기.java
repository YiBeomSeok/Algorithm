package inflearn.java;

import java.util.Scanner;

public class _1_5_특정_문자_뒤집기 {

    public static String solution(String input) {

        char[] chars = input.toCharArray();
        int lt = 0;
        int rt = input.length() - 1;

        while(lt < rt) {
            if(!Character.isAlphabetic(chars[lt]))
                lt++;
            else if(!Character.isAlphabetic(chars[rt]))
                rt--;
            else {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(solution(input));
    }
}
