package inflearn.java;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _2_1_큰_수_출력하기 {
    public static int[] solution(int[] ints) {
        ArrayList<Integer> answer = new ArrayList<>();

        int prev = Integer.MIN_VALUE;
        for (int anInt : ints) {
            if(anInt > prev) {
                answer.add(anInt);
            }
            prev = anInt;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] ints = new int[n];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        ints = solution(ints);

        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
