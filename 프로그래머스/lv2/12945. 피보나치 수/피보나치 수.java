class Solution {
    int[] fibNums = new int[100001];

    public int solution(int n) {
        fibNums[0] = 0;
        fibNums[1] = 1;
        
        return fib(n) % 1234567;
    }

    private int fib(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(fibNums[n] == 0) {
            fibNums[n] = (fib(n - 1) % 1234567 + fib(n - 2) % 1234567) % 1234567;
        }
        return fibNums[n];
    }
}
