package inflearn.java;

import java.util.Arrays;
import java.util.Scanner;

public class _1_5_특정_문자_뒤집기 {

    public static String solution(String input) {

        char[] chars = input.toCharArray();
        int l = 0;
        int r = input.length() - 1;
        while(true) {
            while(!Character.isAlphabetic(chars[l]))
                l++;
            while(!Character.isAlphabetic(chars[r]))
                r--;
            if(l > r) break;
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(solution(input));
    }
}
