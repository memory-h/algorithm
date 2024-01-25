package bfs.gold.gold_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14502 {

    static int n, m;
    static int max = 0;
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

        dfs(0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    private static void dfs(int wall) {

        // 벽을 3개 세웠으면 bfs 탐색 시작
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(wall + 1);
                    graph[i][j] = 0;
                }
            }
        }

    }

    private static void bfs() {

        Queue<Virus> queue = new LinkedList<>();
        int[][] virus = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virus[i][j] = graph[i][j];

                // 바이러스를 큐에 저장
                if (virus[i][j] == 2) {
                    queue.offer(new Virus(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Virus now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 바이러스 확산
                if (virus[nx][ny] == 0) {
                    virus[nx][ny] = 2;
                    queue.offer(new Virus(nx, ny));
                }
            }
        }

        int count = 0;

        // 얻을 수 있는 안전 영역의 최대 크기를 구한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus[i][j] == 0) {
                    count++;
                }
            }
        }

        max = Math.max(max, count);
    }

    static class Virus {
        private final int x;
        private final int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}