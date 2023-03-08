package inflearn.java.ch03;

import java.util.Scanner;

public class _3_5_연속된_자연수의_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int lt = 1;
        int sum = lt;
        int answer = 0;
        for(int rt = 2; rt <= n / 2 + 1; rt++) {
            sum += rt;
            if(sum == n) answer++;
            while(sum >= n) {
                sum -= lt++;
                if(sum == n) answer++;
            }
        }
        return answer;
    }
}
