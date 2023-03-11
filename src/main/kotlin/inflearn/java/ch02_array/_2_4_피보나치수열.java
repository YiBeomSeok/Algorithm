package inflearn.java.ch02_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _2_4_피보나치수열 {

    public static List<Integer> solution(int n) {
        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;

        for(int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return Arrays.stream(fib).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for(int elem : solution(input)) {
            System.out.print(elem + " ");
        }
    }
}
