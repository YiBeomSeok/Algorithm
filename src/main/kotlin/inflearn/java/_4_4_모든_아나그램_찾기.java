package inflearn.java;

import java.io.*;
import java.util.*;

public class _4_4_모든_아나그램_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));
    }

    public static int solution(String s1, String s2) {

        HashMap<Character, Integer> s2Counts = new HashMap<>();
        Queue<Character> s1Queue = new ArrayDeque<>();

        for(char ch : s2.toCharArray()) {
            s2Counts.put(ch, s2Counts.getOrDefault(ch, 0) + 1);
        }

        int anagramCount = 0;
        for(int currentIndex = 0; currentIndex < s1.length(); currentIndex++) {
            char currentChar = s1.charAt(currentIndex);

            if(s2Counts.containsKey(currentChar)) {
                s1Queue.add(currentChar);
                int newCount  = s2Counts.get(currentChar) - 1;
                if(newCount == 0) {
                    s2Counts.remove(currentChar);
                } else {
                    s2Counts.put(currentChar, newCount);
                }
            } else {
                while(!s1Queue.isEmpty()) {
                    char oldestChar = s1Queue.poll();
                    s2Counts.put(oldestChar, s2Counts.getOrDefault(oldestChar, 0) + 1);
                }
            }

            if(s1Queue.size() == s2.length()){
                anagramCount++;
                char oldestChar = s1Queue.remove();
                s2Counts.put(oldestChar, s2Counts.getOrDefault(oldestChar, 0) + 1);
            }
        }

        return anagramCount;
    }
}
