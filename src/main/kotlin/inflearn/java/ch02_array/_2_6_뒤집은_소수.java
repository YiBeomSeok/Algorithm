package inflearn.java.ch02_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2_6_뒤집은_소수 {
    public static int[] solution(int[] intArray) {

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(new StringBuilder().append(intArray[i]).reverse().toString());
        }

        int max = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (max < intArray[i]) max = intArray[i];
        }

        int[] ch = new int[max + 1];
        ch[0] = 1;
        ch[1] = 1;
        for (int i = 2; i <= max; i++) {
            if (ch[i] == 0) {
                for (int j = i + i; j <= max; j += i) {
                    ch[j] = 1;
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < intArray.length; i++) {
            if (ch[intArray[i]] == 0)
                answer.add(intArray[i]);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] sol = solution(input);

        for (int anInt : sol) {
            System.out.print(anInt + " ");
        }
    }
}
