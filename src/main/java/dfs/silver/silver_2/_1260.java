package dfs.silver.silver_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260 {

    private static int n;
    private static int[][] graph;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        visited = new boolean[n + 1];
        dfs(v);

        sb.append("\n");

        visited = new boolean[n + 1];
        bfs(v);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[node][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[v][i] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

}