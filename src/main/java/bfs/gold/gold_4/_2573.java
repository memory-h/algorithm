package bfs.gold.gold_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2573 {

    static int n, m;
    static int[][] graph;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(answer());
        bw.flush();
        bw.close();
    }

    private static String answer() {
        int count, years = 0;

        // 빙산이 두 덩어리 이상으로 분리될 때까지 반복 실행
        while ((count = findIcebergCount()) < 2) {
            // 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력
            if (count == 0) {
                return "0";
            }
            bfs();

            years++;
        }

        return String.valueOf(years);
    }

    private static int findIcebergCount() {
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        // 빙산의 개수를 dfs 탐색으로 구한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] != 0) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (!visited[nx][ny] && graph[nx][ny] != 0) {
                dfs(nx, ny, visited);
            }
        }
    }

    private static void bfs() {
        Queue<Iceberg> queue = new LinkedList<>();

        // 방문 처리를 하지 않으면 빙하가 1 → 0이 되는 경우 빙산이 아니라 바닷물이라고 판단하여 필요 이상으로 빙산을 녹이게 된다.
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 0) {
                    queue.add(new Iceberg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Iceberg iceberg = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + iceberg.x;
                int ny = dy[i] + iceberg.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 바닷물인 경우 해당 빙산 크기를 1만큼 녹인다.
                if (!visited[nx][ny] && graph[nx][ny] == 0) {
                    if (graph[iceberg.x][iceberg.y] > 0) {
                        graph[iceberg.x][iceberg.y]--;
                    }
                }
            }
        }
    }

    static class Iceberg {
        private final int x;
        private final int y;

        public Iceberg(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}