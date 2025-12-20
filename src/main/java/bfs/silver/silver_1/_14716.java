package bfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _14716 {

    private static int m, n;

    private static int[][] graph;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    private static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    bfs(i, j);
                    totalCount++;
                }
            }
        }

        bw.write(String.valueOf(totalCount));
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            for (int i = 0; i < 8; i++) {
                int cx = position.x + dx[i];
                int cy = position.y + dy[i];

                if (cx < 0 || cy < 0 || cx >= m || cy >= n) {
                    continue;
                }

                if (!visited[cx][cy] && graph[cx][cy] == 1) {
                    visited[cx][cy] = true;
                    queue.offer(new Position(cx, cy));
                }
            }
        }
    }

    private static class Position {

        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}