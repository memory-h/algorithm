package bfs.silver.silver_2;

import java.io.*;
import java.util.*;

public class _14496 {

    private static int n;
    private static int m;
    private static int result = -1;

    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        bfs(a, b);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs(int startNode, int endNode) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startNode, 0});
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == endNode) {
                result = cur[1];
                return;
            }

            for (int node : graph[cur[0]]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(new int[]{node, cur[1] + 1});
                }
            }
        }
    }

}