package stack.silver.silver_3;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class _12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int sequence = 1;

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());

            // 스택의 맨 위 항목이 sequence와 같은 경우
            while (!stack.isEmpty() && stack.peek() == sequence) {
                stack.pop();
                sequence++;
            }

            // 현재 학생의 번호가 sequence와 같은 경우
            if (current == sequence) {
                sequence++;
            } else { // 일치하지 않는 경우
                stack.push(current);
            }
        }

        while (!stack.isEmpty()) {
            // 스택에서 pop()를 호출했을 때 sequence와 다른 경우
            if (stack.pop() != sequence) {
                bw.write("Sad");
                bw.flush();
                bw.close();

                return;
            }
            sequence++;
        }

        bw.write("Nice");
        bw.flush();
        bw.close();
    }

}