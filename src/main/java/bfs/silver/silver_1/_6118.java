package bfs.silver.silver_1;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6118 {

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] result; // 헛간 번호, 거리, 개수를 저장하는 배열
    static boolean[] visited;

    private static void bfs() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // 현재 거리가 이전 거리보다 크면 값을 갱신
            if (node.weight > result[1]) {
                result[0] = node.edge;
                result[1] = node.weight;
                result[2] = 1;
            }

            // 거리가 같다면 개수를 증가시키고, 더 작은 번호로 갱신
            else if (node.weight == result[1]) {
                result[2]++;
                result[0] = Math.min(result[0], node.edge);
            }

            for (int value : graph.get(node.edge)) {
                if (!visited[value]) {
                    visited[value] = true;
                    queue.offer(new Node(value, node.weight + 1));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        result = new int[3];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs();

        bw.write(result[0] + " " + result[1] + " " + result[2]);
        bw.flush();
        bw.close();
    }

    static class Node {
        private final int edge;
        private final int weight;

        public Node(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }

}