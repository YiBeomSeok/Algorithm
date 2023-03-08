package inflearn.java.ch05;

import java.util.*;
import java.io.*;

public class _5_4_후위식_연산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String prefix = br.readLine();

        System.out.println(calPrefix(prefix));
    }

    public static String infixToPrefix(String infix) {

        StringBuilder prefix = new StringBuilder();
        Stack<Character> operator = new Stack<>();
        HashMap<Character, Integer> opPriority = new HashMap<>();
        opPriority.put('*', 1);
        opPriority.put('/', 1);
        opPriority.put('+', 2);
        opPriority.put('-', 2);
        opPriority.put('(', 3);

        for (char ch : infix.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                prefix.append(ch);
            } else if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
                if (!operator.isEmpty()) {
                    char prevOp = operator.peek();
                    if (opPriority.get(prevOp) <= opPriority.get(ch)) {
                        prefix.append(operator.pop());
                    }
                }
                operator.push(ch);
            } else if (ch == '(') {
                operator.push(ch);
            } else if (ch == ')') {
                while(!operator.isEmpty()) {
                    char prevOp = operator.pop();
                    if(prevOp == '(') {
                        break;
                    }
                    prefix.append(prevOp);
                }
            }
        }
        if(!operator.isEmpty()) {
            prefix.append(operator.pop());
        }

        return prefix.toString();
    }

    public static int calPrefix(String prefix) {
        int answer = 0;

        Stack<Integer> numbers = new Stack<>();
        for(char ch : prefix.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                numbers.push(ch - '0');
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int n1 = numbers.pop();
                int n2 = numbers.pop();
                if(ch == '+') {
                    numbers.push(n1 + n2);
                } else if(ch == '-') {
                    numbers.push(n2 - n1);
                } else if (ch == '*') {
                    numbers.push(n2 * n1);
                } else if(ch == '/') {
                    numbers.push(n2 / n1);
                }
            }
        }
        answer = numbers.pop();
        return answer;
    }
}
