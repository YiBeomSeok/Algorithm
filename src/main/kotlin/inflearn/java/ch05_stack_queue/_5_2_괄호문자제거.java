package inflearn.java.ch05_stack_queue;

import java.io.*;
import java.util.*;

public class _5_2_괄호문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(removeBrackets(str));
    }

    public static String solution(String input) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        int leftCount = 0;

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);

            if(ch == ')' && leftCount > 0) {
                while(true) {
                    char lastChar = deque.removeLast();
                    leftCount -= lastChar == '(' ? 1 : 0;
                    if(lastChar == '(') break;
                }
            } else {
                leftCount += ch == '(' ? 1 : 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }

    // 많이 개선된 풀이
    public static String removeBrackets(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        int leftCount = 0;

        for (char c : input.toCharArray()) {
            if (c == '(') {
                leftCount++;
            } else if (c == ')' && leftCount > 0) {
                leftCount--;
            } else if (leftCount == 0) {
                deque.addLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
