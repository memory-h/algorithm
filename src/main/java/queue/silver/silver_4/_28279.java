package queue.silver.silver_4;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        while (n --> 0) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());

            switch (order) {
                // 정수 X를 덱의 앞에 넣는다.
                case 1 :
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                // 정수 X를 덱의 뒤에 넣는다.
                case 2:
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;

                // 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
                case 3:
                    if (!dq.isEmpty()) sb.append(dq.pollFirst()).append("\n");
                    else sb.append("-1\n");
                    break;

                // 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
                case 4:
                    if (!dq.isEmpty()) sb.append(dq.pollLast()).append("\n");
                    else sb.append("-1\n");
                    break;

                // 덱에 들어있는 정수의 개수를 출력한다.
                case 5:
                    sb.append(dq.size()).append("\n");
                    break;

                // 덱이 비어있으면 1, 아니면 0을 출력한다.
                case 6:
                    if (dq.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;

                // 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
                case 7:
                    if (!dq.isEmpty()) sb.append(dq.peekFirst()).append("\n");
                    else sb.append("-1\n");
                    break;

                // 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
                case 8:
                    if (!dq.isEmpty()) sb.append(dq.peekLast()).append("\n");
                    else sb.append("-1\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}