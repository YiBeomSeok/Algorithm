package inflearn.java.ch01_string;

import java.util.Scanner;

public class _1_3_문장_속_단어 {
    public static String solution(String str) {
        String[] strArray = str.split(" ");
        String max = strArray[0];
        for(String elem: strArray) {
            if(elem.length() > max.length())
                max = elem;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
        return;
    }
}
