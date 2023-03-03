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

        for (char ch : s2.toCharArray()) {
            s2Counts.put(ch, s2Counts.getOrDefault(ch, 0) + 1);
        }

        int anagramCount = 0;
        for (int currentIndex = 0; currentIndex < s1.length(); currentIndex++) {
            char currentChar = s1.charAt(currentIndex);

            if (s2Counts.containsKey(currentChar)) {
                s1Queue.add(currentChar);
                int newCount = s2Counts.get(currentChar) - 1;
                if (newCount == 0) {
                    s2Counts.remove(currentChar);
                } else {
                    s2Counts.put(currentChar, newCount);
                }
            } else {
                while (!s1Queue.isEmpty()) {
                    char oldestChar = s1Queue.poll();
                    s2Counts.put(oldestChar, s2Counts.getOrDefault(oldestChar, 0) + 1);
                }
            }

            if (s1Queue.size() == s2.length()) {
                anagramCount++;
                char oldestChar = s1Queue.remove();
                s2Counts.put(oldestChar, s2Counts.getOrDefault(oldestChar, 0) + 1);
            }
        }

        return anagramCount;
    }

    public static int solution2(String s1, String s2) {
        int answer = 0;
        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();
        for (char x : s2.toCharArray())
            bMap.put(x, bMap.getOrDefault(x, 0) + 1);
        int L = s2.length() - 1;
        for (int i = 0; i < L; i++) {
            aMap.put(s1.charAt(i), aMap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int lt = 0;
        for (int rt = L; rt < s1.length(); rt++) {
            aMap.put(s1.charAt(rt), aMap.getOrDefault(s1.charAt(rt), 0) + 1);
            if (aMap.equals(bMap)) answer++;
            aMap.put(s1.charAt(lt), aMap.get(s1.charAt(lt)) - 1);
            if (aMap.get(s1.charAt(lt)) == 0) aMap.remove(s1.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static int findAnagrams(String s1, String s2) {
        int count = 0;

        Map<Character, Integer> s2Freqs = new HashMap<>();
        for (char ch : s2.toCharArray()) {
            s2Freqs.put(ch, s2Freqs.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> s1WindowFreqs = new HashMap<>();
        int left = 0, right = 0;
        while (right < s1.length()) {
            char currentChar = s1.charAt(right);
            s1WindowFreqs.put(currentChar, s1WindowFreqs.getOrDefault(currentChar, 0) + 1);
            right++;

            if (right - left == s2.length()) {
                if (s1WindowFreqs.equals(s2Freqs)) {
                    count++;
                }
                char leftChar = s1.charAt(left);
                s1WindowFreqs.put(leftChar, s1WindowFreqs.get(leftChar) - 1);
                if (s1WindowFreqs.get(leftChar) == 0) {
                    s1WindowFreqs.remove(leftChar);
                }
                left++;
            }
        }

        return count;
    }
}
