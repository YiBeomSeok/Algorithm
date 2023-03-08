package inflearn.java.ch01;

import java.util.ArrayList;
import java.util.Scanner;

public class _1_6_중복문자제거 {

    /**
     * indexOf(str.charAt(i))를 사용하면 해당 문자가 나타나는 가장 첫 인덱스를 반환한다.
     * 이를 이용해 이 인덱스와 현재 조사하는 인덱스 i가 같은지를 판별한다!!
     */
    public static String solution(String str) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if(i == str.indexOf(str.charAt(i)))
                answer.append(str.charAt(i));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(solution(input));
    }
}
