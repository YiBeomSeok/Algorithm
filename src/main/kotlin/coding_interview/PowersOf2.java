package coding_interview;

public class PowersOf2 {
    /**
     * 1과 n을 포함하여 그 사이에 있는 모든 2의 승수를 출력한다.
     * 예를 들어 n이 4일 때 이 함수는 1, 2, 4를 출력한다.
     * @param n
     * @return
     */
    int powersOf2(int n) {
        if(n < 1) {
            return 0;
        } else if(n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powersOf2(n/2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }
}
