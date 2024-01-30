package bfs.gold.gold_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _13913 {

    static int n, k, time;
    static int[] graph;
    static int[] arr;
    static boolean[] visited;

    static int[] move = {1, -1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[100001];
        arr = new int[100001];
        visited = new boolean[100001];

        bfs();

        // Stack을 이용해 이동 경로 역추적
        Stack<Integer> stack = new Stack<>();
        stack.push(k);

        int temp = k;

        while (temp != n) {
            stack.push(arr[temp]);
            temp = arr[temp];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        bw.write(time + "\n" + sb);
        bw.flush();
        bw.close();
    }

    private static void bfs() {

        Queue<Hide> queue = new LinkedList<>();
        queue.add(new Hide(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Hide hide = queue.poll();

            if (hide.position == k) {
                time = hide.count;

                return;
            }

            int value;

            for (int i = 0; i < 3; i++) {
                if (i != 2) {
                    value = move[i] + hide.position;
                }
                else {
                    value = move[i] * hide.position;
                }

                if (value < 0 || value > 100000) {
                    continue;
                }

                if (!visited[value]) {
                    visited[value] = true;
                    arr[value] = hide.position; // 이동 경로 저장
                    queue.add(new Hide(value, hide.count + 1));
                }
            }
        }

    }

    static class Hide {
        private final int position;
        private final int count;

        public Hide(int position, int count) {
            this.position = position;
            this.count = count;
        }
    }

}