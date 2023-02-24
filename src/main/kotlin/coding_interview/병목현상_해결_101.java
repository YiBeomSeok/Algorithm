package coding_interview;

import java.util.*;

/**
 * 직접 해 보는중
 * <p>
 * 서로 다른 정수로 이루어진 배열이 있을 때 두 정수의 차이가 k인 쌍의 개수를 세라.
 * 예를 들어 주어진 배열이 {1, 7, 5, 9, 2, 12, 3}이고 k = 2이면, 두 정수의 차이가 2인 쌍은 다음과 같이 네 개 존재한다.
 * (1,3), (3,5), (5,7), (7,9)
 */
public class 병목현상_해결_101 {

    public static int[][] solution(int[] arr, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int j : arr) {
            hashSet.add(j);
        }

        ArrayList<int[]> answer = new ArrayList<>();
        for (int nowInt : arr) {
            if (hashSet.contains(nowInt - k)) {
                answer.add(new int[]{nowInt - k, nowInt});
            }
            if (hashSet.contains(nowInt + k)) {
                answer.add(new int[]{nowInt, nowInt + k});
            }
            hashSet.remove(nowInt);
        }

        int[][] ans = new int[answer.size()][2];
        for(int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int[] intArray = new int[7];
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < 7; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
        }
        int[][] pairs = solution(intArray, k);

        for (int[] pair : pairs) {
            System.out.printf("(%d,%d), ", pair[0], pair[1]);
        }
    }
}
