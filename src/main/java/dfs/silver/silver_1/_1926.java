package dfs.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _1926 {

    static int n, m, area;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void dfs(int x, int y) {

        // 방문 처리 및 그림의 넓이 증가
        visited[x][y] = true;
        area++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (!visited[nx][ny] && graph[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }

    }

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

        int picture = 0, max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                area = 0;

                // 그림이고 방문하지 않았을 때 dfs 탐색
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    picture++;
                    max = Math.max(max, area);
                }
            }
        }

        bw.write(picture + "\n" + max);
        bw.flush();
        bw.close();
    }
}