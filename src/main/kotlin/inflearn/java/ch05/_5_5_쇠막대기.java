package inflearn.java.ch05;

import java.util.Scanner;
import java.util.Stack;

public class _5_5_쇠막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
    }

    public static int solution(String s) {
        int answer = 0;

        Stack<Integer> bar = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (bracket == '(') {
                bar.push(0);
            } else if (bracket == ')') {
                if (!bar.isEmpty()) {
                    int prev = bar.pop();
                    if (prev > 0) {
                        answer += prev + 1;
                    } else if (prev == 0) {
                        prev = 1;
                    }
                    if (!bar.isEmpty())
                        bar.push(bar.pop() + prev);
                }
            }
        }
        return answer;
    }

    // 스택을 사용하지 않는 방식으로 개선
    public static int effectiveSolution(String s) {
        int answer = 0;
        int sticks = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                answer += sticks;
                i++; // 레이저의 길이가 2이므로, 다음 문자를 건너뜁니다.
            } else if (s.charAt(i) == '(') {
                sticks++;
            } else if (s.charAt(i) == ')') {
                answer++;
                sticks--;
            }
        }
        return answer;
    }

    public static int solution2(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            }
            else {
                stack.pop();
                char prev = s.charAt(i - 1);
                if(prev == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }
}
