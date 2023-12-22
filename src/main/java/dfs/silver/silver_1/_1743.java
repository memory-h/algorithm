package dfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _1743 {

    static int n, m, count;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1 ,0, -1, 0};
    static int[] dy = {0 ,1, 0, -1};

    private static void dfs(int x, int y) {

        // 방문 처리하고, 음식물 크기 1 증가
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (graph[nx][ny] == 1 && !visited[nx][ny]) {
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
        int k = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            graph[r][c] = 1;
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = 0;

                // 음식물이 있고, 방문하지 않았을 때
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);

                    // 제일 큰 음식물의 크기를 구한다.
                    max = Math.max(max, count);
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}