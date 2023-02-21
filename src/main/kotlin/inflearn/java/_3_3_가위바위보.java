package inflearn.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _3_3_가위바위보 {

    private static String match(int a, int b) throws InvalidParameterException{
        if(a == 1) {
            if(b == 1) return "D";
            else if(b == 2) return "B";
            else if(b == 3) return "A";
        }
        else if(a == 2) {
            if(b == 1) return "A";
            else if(b == 2) return "D";
            else if(b == 3) return "B";
        }
        else if(a == 3) {
            if(b == 1) return "B";
            else if(b == 2) return "A";
            else if(b == 3) return "D";
        }

        throw new InvalidParameterException();
    }

    public static List<String> solution(int[] inputA, int[] inputB) {
        List<String> answer = new ArrayList<String>();

        int len = inputA.length;

        for (int i = 0; i < len; i++) {
            answer.add(match(inputA[i], inputB[i]));
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inputA = new int[n], inputB = new int[n];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputA[i] = Integer.parseInt(stA.nextToken());
            inputB[i] = Integer.parseInt(stB.nextToken());
        }

        List<String> ans = solution(inputA, inputB);
        for(String result : ans) {
            System.out.println(result);
        }
    }
}
