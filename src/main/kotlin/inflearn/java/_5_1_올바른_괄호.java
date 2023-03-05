package inflearn.java;

import java.io.*;
import java.util.*;

public class _5_1_올바른_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean result = solution(input);

        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static boolean solution(String str) {
        int count = 0;
        for(char ch : str.toCharArray()) {
            if(ch == '(') count++;
            else if(ch == ')') count--;

            if(count < 0) return false;
        }
        return count == 0;
    }

    // 위의 해결법은 괄호 종류가 하나일 경우.
    // 괄호 종류가 많아질 경우 사용하기 어려움

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') { // 열린 괄호일 경우
                stack.push(c);
            } else if (!stack.isEmpty() && // 스택이 비어있지 않고
                    ((c == ')' && stack.peek() == '(') || // 짝이 맞는 경우
                            (c == '}' && stack.peek() == '{') ||
                            (c == ']' && stack.peek() == '['))) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty(); // 스택이 비어있으면 true, 아니면 false 반환
    }
}
