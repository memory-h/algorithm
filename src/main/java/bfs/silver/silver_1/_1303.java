package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1303 {

    private static int n, m;
    private static char[][] graph;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new  StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String soldier = br.readLine();

            for (int j = 0; j < n; j++) {
                graph[i][j] = soldier.charAt(j);
            }
        }

        int bluePower = 0;
        int whitePower = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;

                    if (graph[i][j] == 'B') {
                        bluePower += bfs(i, j, 'B');
                    } else if (graph[i][j] == 'W') {
                        whitePower += bfs(i, j, 'W');
                    }
                }
            }
        }

        bw.write(whitePower + " " + bluePower);
        bw.flush();
        bw.close();
    }

    private static int bfs(int x, int y, char soldier) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        int soldierCount = 1;

        while (!queue.isEmpty()) {
            Position curPosition = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curPosition.x + dx[i];
                int ny = curPosition.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == soldier) {
                    visited[nx][ny] = true;
                    soldierCount++;
                    queue.offer(new Position(nx, ny));
                }
            }
        }

        return soldierCount * soldierCount;
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