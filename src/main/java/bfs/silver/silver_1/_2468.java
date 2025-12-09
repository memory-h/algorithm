package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2468 {

    private static int n;
    private static int[][] graph;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        int maxAreaValue = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxAreaValue = Math.max(graph[i][j], maxAreaValue);
            }
        }

        int maxSafetyArea = 0;

        for (int k = 0; k <= maxAreaValue; k++) {
            visited = new boolean[n][n];
            int safetyAreaCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && graph[i][j] > k) {
                        bfs(i, j, k);
                        safetyAreaCount++;
                    }
                }
            }
            maxSafetyArea = Math.max(maxSafetyArea, safetyAreaCount);
        }

        bw.write(String.valueOf(maxSafetyArea));
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y, int notSafetyArea) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] > notSafetyArea) {
                    visited[nx][ny] = true;
                    queue.offer(new Position(nx, ny));
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