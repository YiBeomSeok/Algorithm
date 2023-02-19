package coding_interview;

public class Permutations {
    /**
     * 문자열로 나타낼 수 있는 순열의 개수를 구하는 코드
     * @param str
     */
    void permutation(String str) {
        permutation(str, "");
    }

    void permutation(String str, String prefix) {
        if(str.length() == 0) {
            System.out.println(prefix);
        } else {
            for(int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
