package bfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _2178 {

    private static int n, m;
    private static int[][] graph;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new  StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y, 1));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            if (position.x == n - 1 && position.y == m - 1) {
                return position.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Position(nx, ny, position.depth + 1));
                }
            }
        }

        return 0;
    }

    private static class Position {

        private final int x;
        private final int y;
        private final int depth;

        public Position(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

    }

}