package bfs.silver.silver_2;

import java.io.*;
import java.util.*;

public class _18352 {

    private static int n;
    private static int m;
    private static int k;
    private static int x;

    private static List<List<Integer>> graph;
    private static List<Integer> nodes;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 도시의 개수
        m = Integer.parseInt(st.nextToken()); // 도로의 개수
        k = Integer.parseInt(st.nextToken()); // 거리 정보
        x = Integer.parseInt(st.nextToken()); // 출발 도시의 정보

        graph = new ArrayList<>();
        nodes = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        bfs();

        Collections.sort(nodes);

        for (int node : nodes) {
            sb.append(node).append("\n");
        }

        bw.write(sb.length() == 0 ? "-1" : sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[1] == k) {
                nodes.add(cur[0]);
            }

            for (int next : graph.get(cur[0])) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, cur[1] + 1});
                }
            }
        }
    }

}