package stack.silver.silver_3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _1935 {

    static String expression;
    static Map<Character, Double> operandValues;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        expression = br.readLine();

        operandValues = new HashMap<>();

        // 피연산자에 대응하는 값 저장
        for (int i = 0; i < n; i++) {
            double value = Double.parseDouble(br.readLine());

            operandValues.put((char) ('A' + i), value);
        }

        System.out.printf("%.2f", calculatePostfix());
    }

    private static double calculatePostfix() {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isLetter(c)) {
                // 피연산자이면 스택에 push
                stack.push(operandValues.get(c));
            } else {
                // 연산자를 만나면 스택에서 두 개의 피연산자를 pop하여 연산 수행
                double b = stack.pop();
                double a = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;

                    case '-':
                        stack.push(a - b);
                        break;

                    case '*':
                        stack.push(a * b);
                        break;

                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }

}