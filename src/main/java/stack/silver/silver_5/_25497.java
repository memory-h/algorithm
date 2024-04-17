package stack.silver.silver_5;

import java.io.*;
import java.util.Stack;

public class _25497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        Stack<Character> skillL = new Stack<>();
        Stack<Character> skillS = new Stack<>();

        int count = 0;

        outerLoop: // 레이블을 정의
        for (int i = 0; i < n; i++) {
            switch (input.charAt(i)) {
                case 'L':
                    skillL.push(input.charAt(i));
                    break;

                case 'R':
                    // 스택이 비어있지 않고, peek() 값이 L이 경우
                    if (!skillL.isEmpty() && skillL.peek() == 'L') {
                        skillL.pop();
                        count++;
                    } else {
                        break outerLoop; // 레이블로 지정된 반복문을 종료
                    }
                    break;

                case 'S':
                    skillS.push(input.charAt(i));
                    break;

                case 'K':
                    // 스택이 비어있지 않고, peek() 값이 S이 경우
                    if (!skillS.isEmpty() && skillS.peek() == 'S') {
                        skillS.pop();
                        count++;
                    } else {
                        break outerLoop; // 레이블로 지정된 반복문을 종료
                    }
                    break;

                // 기술 1~9인 경우
                default:
                    count++;
                    break;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

}