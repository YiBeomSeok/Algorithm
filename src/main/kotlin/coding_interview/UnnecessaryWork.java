package coding_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * a, b, c, d가 1에서 1000 사이에 있는 정수 값 중 하나일 때
 * `a^3 + b^3 = c^3 + d^3`을 만족하는 모든 자연수를 출력하시오.
 */
public class UnnecessaryWork {
    // O(n^4)
    public static void solution1(int n) {
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    for (int d = 1; d <= n; d++) {
                        if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 4)) {
                            System.out.printf("%d, %d, %d, %d\n", a, b, c, d);
                        }
                    }
                }
            }
        }
    }

    // O(n^3)
    public static void solution2(int n) {
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    int d = (int) Math.pow(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3), 1 / 3f);
                    if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 4)) {
                        System.out.printf("%d, %d, %d, %d\n", a, b, c, d);
                    }
                }
            }
        }
    }

    // O(n^2)
    public static void solution3(int n) {
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int c = 1; c <= n; c++) {
            for(int d = 1; d <= n; d++) {
                int result = (int) (Math.pow(c, 3) + Math.pow(d, 3));
                map.computeIfAbsent(result, key -> new ArrayList<>()).add(new int[] {c, d});
            }
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int result = (int) (Math.pow(a, 3) + Math.pow(b, 3));
                ArrayList<int[]> list = map.get(result);
                for(int[] pair : list) {
                    System.out.printf("%d %d %d %d\n", a, b, pair[0], pair[1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        solution3(1000);
    }
}
