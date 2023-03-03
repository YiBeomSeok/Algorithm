package inflearn.java;

import java.util.*;
import java.io.*;

public class _4_1_학급_회장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(solution(n, str));
    }

    public static char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> candidates = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            candidates.put(c, candidates.getOrDefault(c, 0) + 1);
        }
        int maxVotes = -1;
        for (char key : candidates.keySet()) {
            int votes = candidates.get(key);
            if (votes > maxVotes) {
                maxVotes = votes;
                answer = key;
            }
        }
        return answer;
    }
}
