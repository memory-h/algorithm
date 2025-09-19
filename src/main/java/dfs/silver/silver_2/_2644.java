package dfs.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _2644 {

    private static int n;
    private static int end;
    private static int result = -1;

    private static int[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(start, 0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void dfs(int node, int depth) {
        visited[node] = true;

        if (node == end) {
            result = depth;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                dfs(i, depth + 1);
            }
        }
    }

}