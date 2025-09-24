package dfs.silver.silver_2;

import java.io.*;
//import java.util.Stack;
import java.util.StringTokenizer;

public class _11724 {

    private static int n;
    private static int m;

    private static int[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

//    private static void dfs(int startNode) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(startNode);
//        visited[startNode] = true;
//
//        while (!stack.isEmpty()) {
//            int cur = stack.pop();
//
//            for (int i = 1; i <= n; i++) {
//                if (!visited[i] && graph[cur][i] == 1) {
//                    visited[i] = true;
//                    stack.push(i);
//                }
//            }
//        }
//    }

}