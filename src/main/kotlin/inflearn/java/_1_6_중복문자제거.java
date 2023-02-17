package inflearn.java;

import java.util.ArrayList;
import java.util.Scanner;

public class _1_6_중복문자제거 {

    public static String solution(String input) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Character> arrayList = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            if (!arrayList.contains(ch))
                arrayList.add(ch);
        }

        for(char ch : arrayList) {
            answer.append(ch);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(solution(input));
    }
}
