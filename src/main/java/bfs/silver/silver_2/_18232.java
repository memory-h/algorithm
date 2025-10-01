package bfs.silver.silver_2;

import java.io.*;
import java.util.*;

public class _18232 {

    private static int n;

    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int result = bfs(s, e);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int bfs(int startNode, int endNode) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startNode, 0});
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if (node[0] == endNode) {
                return node[1];
            }

            for (int next : graph.get(node[0])) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, node[1] + 1});
                }
            }

            if (node[0] - 1 > 0 && !visited[node[0] - 1]) {
                visited[node[0] - 1] = true;
                queue.add(new int[]{node[0] - 1, node[1] + 1});
            }

            if (node[0] + 1 <= n && !visited[node[0] + 1]) {
                visited[node[0] + 1] = true;
                queue.add(new int[]{node[0] + 1, node[1] + 1});
            }
        }

        return 0;
    }

}