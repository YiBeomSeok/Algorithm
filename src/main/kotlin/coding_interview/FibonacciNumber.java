package coding_interview;

public class FibonacciNumber {
    int fib(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * n 까지의 모든 피보나치 수열을 구하는 함수
     * - 형편 없는 알고리즘
     *
     * @param n
     */
    void _allFib(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + fib(i));
        }
    }

    /**
     * n 까지의 모든 피보나치 수열을 구하는 함수
     * - 캐시를 이용한 메모이제이션(memoization)
     *
     * @param n
     */
    void allFib(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib(n, memo));
        }
    }

    /**
     * 이전에 계산된 결과값을 정수 배열에 저장(캐시)한다.
     * 알고리즘 중간에 이미 저장된 값이 있다면 그 캐시값을 반환한다.
     * @param n: 피보나치 수열의 마지막 번호
     * @param memo: 계산된 결과값을 저장할 배열. 크기는 n + 1 이상이어야 한다.
     * @return n에 해당하는 피보나치 수열
     */
    int fib(int n, int[] memo) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (memo[n] > 0) return memo[n];
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }
}
