package deque.silver.silver_4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        while (n --> 0) {
            st = new StringTokenizer(br.readLine());

            String input = st.nextToken();
            int x;

            switch (input) {
                // 정수 X를 덱의 앞에 넣는다.
                case "push_front":
                    x = Integer.parseInt(st.nextToken());
                    deque.addFirst(x);
                    break;

                // 정수 X를 덱의 뒤에 넣는다.
                case "push_back":
                    x = Integer.parseInt(st.nextToken());
                    deque.addLast(x);
                    break;

                case "pop_front": {
                    Integer poll = deque.pollFirst();

                    // 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다.
                    if (poll != null) {
                        sb.append(poll).append("\n");
                    }

                    // 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    else {
                        sb.append("-1").append("\n");
                    }

                    break;
                }

                case "pop_back": {
                    Integer poll = deque.pollLast();

                    // 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다.
                    if (poll != null) {
                        sb.append(poll).append("\n");
                    }

                    // 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    else {
                        sb.append("-1").append("\n");
                    }

                    break;
                }

                // 덱에 들어있는 정수의 개수를 출력한다.
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;

                // 덱이 비어있으면 1을, 아니면 0을 출력한다.
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;

                case "front":
                    // 덱의 가장 앞에 있는 정수를 출력한다.
                    if (deque.peekFirst() != null) {
                        sb.append(deque.peekFirst()).append("\n");
                    }

                    // 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    else {
                        sb.append("-1").append("\n");
                    }
                    break;

                case "back":
                    // 덱의 가장 뒤에 있는 정수를 출력한다.
                    if (deque.peekLast() != null) {
                        sb.append(deque.peekLast()).append("\n");
                    }

                    // 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    else {
                        sb.append("-1").append("\n");
                    }
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}