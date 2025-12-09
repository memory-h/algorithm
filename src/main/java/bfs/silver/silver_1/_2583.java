package bfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _2583 {

    private static int m, n;
    private static int[][] graph;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    graph[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int totalAreaCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 0) {
                    areas.add(bfs(i, j));
                    totalAreaCount++;
                }
            }
        }

        Collections.sort(areas);

        for (int area : areas) {
            sb.append(area).append(" ");
        }

        bw.write(totalAreaCount + "\n" + sb);
        bw.flush();
        bw.close();
    }

    private static int bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        visited[x][y] = true;
        int areaCount = 1;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    areaCount++;
                    queue.offer(new Position(nx, ny));
                }
            }
        }

        return areaCount;
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