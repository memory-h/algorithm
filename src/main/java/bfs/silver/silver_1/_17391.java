package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17391 {

    static int n, m, result = 0;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs() {

        Queue<Booster> queue = new LinkedList<>();
        queue.add(new Booster(0, 0, 0));

        while (!queue.isEmpty()) {
            Booster booster = queue.poll();

            if (booster.x == n - 1 && booster.y == m - 1) {
                result = booster.count;

                return;
            }

            for (int i = 0; i < 2; i++) {
                // 해당 좌표의 부스터만큼 반복문 실행
                for (int j = 1; j <= graph[booster.x][booster.y]; j++) {
                    int nx = booster.x + dx[i] * j;
                    int ny = booster.y + dy[i] * j;

                    if (nx >= n || ny >= m) {
                        continue;
                    }

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Booster(nx, ny, booster.count + 1));
                    }
                }
            }
        }

    }

    static class Booster {
        private final int x;
        private final int y;
        private final int count;

        public Booster(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}