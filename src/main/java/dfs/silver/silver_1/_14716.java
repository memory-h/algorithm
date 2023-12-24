package dfs.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _14716 {

    static int m, n;
    static int[][] graph;
    static boolean[][] visited;

    // 상, 하, 좌, 우, 대각선
    static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};

    private static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
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

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // dfs 탐색하여 현수막에 있는 글자의 개수를 찾는다.
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}