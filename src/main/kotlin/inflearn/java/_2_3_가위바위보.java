package inflearn.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2_3_가위바위보 {

    private static String match(int a, int b) throws InvalidParameterException{
        // 비기는 경우
        if(a == b) return "D";
        // A가 이기는 경우
        if(a == 1 && b == 3) return "A";
        if(a == 2 && b == 1) return "A";
        if(a == 3 && b == 2) return "A";
        // B가 이기는 경우
        // return "B"; //이렇게 끝나도 충분하지만
        // 만일 a == 2 && b == 1 의 경우를 생각하지 못한 상태여서 작성하지 않았다면
        // `A가 이기는 경우`임에도 "B"를 반환하는 상황이 생긴다.
        // 그래서 실제로는 `else`를 함부로 사용하면 안 되는 것 같다.
        if(b == 1 && a == 3) return "B";
        if(b == 2 && a == 1) return "B";
        if(b == 3 && a == 2) return "B";

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
