package bfs.gold.gold_5;

import java.io.*;
import java.util.*;

public class _14395 {

    static long s, t;
    static char[] operation = {'*', '+', '-', '/'}; // 아스키코드 순서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Long.parseLong(st.nextToken());
        t = Long.parseLong(st.nextToken());

        if (s == t) bw.write("0");
        else bw.write(bfs());


        bw.flush();
        bw.close();
    }

    private static String bfs() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(s, ""));

        // 중복된 값을 제거하기 위해 Set 사용
        Set<Long> set = new HashSet<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.num == t) {
                return node.str;
            }

            for (int i = 0; i < 4; i++) {
                long temp = 0L;

                switch (i) {
                    case 0:
                        temp = node.num * node.num;
                        break;

                    case 1:
                        temp = node.num + node.num;
                        break;

                    case 3:
                        if (node.num != 0) temp = 1L;
                        break;
                }

                if (!set.contains(temp)) {
                    set.add(temp);
                    queue.offer(new Node(temp, node.str + operation[i]));
                }
            }
        }

        return "-1";
    }

    static class Node {
        long num; // 정수 값 저장
        String str; // 연산자 저장

        public Node(long num, String str) {
            this.num = num;
            this.str = str;
        }
    }

}