package bfs.silver.silver_2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18126 {

    static int n;
    static long max;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;

    private static void bfs() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0));
        visited[1] = true;

        // BFS 탐색
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (Node node : graph.get(now.room)) {
                if (!visited[node.room]) {
                    visited[node.room] = true;
                    queue.offer(new Node(node.room, now.value + node.value));
                    max = Math.max(max, now.value + node.value);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        visited = new boolean[n + 1];

        // 양방향으로 연결하는 길의 길이 저장
        for (int i = 0; i < n -1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        max = 0L;
        bfs();

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    static class Node {

        private int room;
        private long value;

        public Node(int room, long value) {
            this.room = room;
            this.value = value;
        }

    }

}