package dfs.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _21938 {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

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
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 세 가지 색상의 평균값을 저장
                graph[i][j] = (r + g + b) / 3;
            }
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 경계값 t보다 크거나 같으면 픽셀값 255
                if (graph[i][j] >= t) {
                    graph[i][j] = 255;
                }
                // 경계값 t보다 작으면 0
                else {
                    graph[i][j] = 0;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // dfs 탐색
                if (!visited[i][j] && graph[i][j] == 255) {
                    visited[i][j] = true;
                    dfs(i, j);
                    result++;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (!visited[nx][ny] && graph[nx][ny] == 255)  {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }

    }

}