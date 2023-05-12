import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Boolean isFirstChar = true;

        for(char ch : s.toCharArray()) {
            if(Character.isLetter(ch)) {
                if(isFirstChar) {
                    answer.append(Character.toUpperCase(ch));
                    isFirstChar = false;
                } else {
                    answer.append(Character.toLowerCase(ch));
                }
            } else if(Character.isDigit(ch)) {
                answer.append(ch);
                isFirstChar = false;
            } else if(ch == ' ') {
                answer.append(ch);
                isFirstChar = true;
            }
        }
        return answer.toString();
    }
}