package inflearn.java.ch05_stack_queue;

import java.io.*;
import java.util.*;

public class _5_7_교육과정_설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        if(solution(s1, s2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean solution(String s1, String s2) {
        Queue<Character> queue = new ArrayDeque<>();
        for(char ch : s1.toCharArray()) {
            queue.offer(ch);
        }

        for(char ch : s2.toCharArray()) {
            if(queue.contains(ch)) {
                if(queue.poll() != ch) {
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }
}
