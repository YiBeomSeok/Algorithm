package coding_interview.problem;

import java.util.Scanner;

public class _1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(toUrl("Mr John Smith"));
    }

    public static String toUrl(String input) {
        return input.replaceAll(" ", "%20");
    }

    public static void replaceSpace(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for(i = 0; i < trueLength; i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if(trueLength < str.length) str[trueLength] = '\0'; // 배열의 끝
        for(i = trueLength - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
