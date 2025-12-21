package bfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _14940 {

    private static int m, n;
    private static int targetX, targetY;

    private static int[][] graph;
    private static int[][] arr;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = -1;

                if (graph[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                    arr[i][j] = 0;
                }

                if (graph[i][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        bfs(targetX, targetY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = position.x + dx[i];
                int cy = position.y + dy[i];

                if (cx < 0 || cy < 0 || cx >= n || cy >= m || graph[cx][cy] == 0) {
                    continue;
                }

                if (!visited[cx][cy] && graph[cx][cy] == 1) {
                    visited[cx][cy] = true;
                    arr[cx][cy] = position.distance + 1;
                    queue.offer(new Position(cx, cy, position.distance + 1));
                }
            }
        }
    }

    private static class Position {

        private final int x;
        private final int y;
        private final int distance;

        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

    }

}