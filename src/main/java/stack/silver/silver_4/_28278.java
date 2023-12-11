package stack.silver.silver_4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class _28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        while (n --> 0) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());

            switch (order) {
                // 정수 X를 스택에 넣는다.
                case 1 :
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                // 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
                case 2 :
                    if (!stack.isEmpty()) sb.append(stack.pop()).append("\n");
                    else sb.append("-1\n");
                    break;

                // 스택에 들어있는 정수의 개수를 출력한다.
                case 3 :
                    sb.append(stack.size()).append("\n");
                    break;

                // 스택이 비어있으면 1, 아니면 0을 출력한다.
                case 4 :
                    if (stack.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;

                /// 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
                case 5 :
                    if (!stack.isEmpty()) sb.append(stack.peek()).append("\n");
                    else sb.append("-1\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}