package dfs.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _1303 {

    static int n, m, whiteCount, blueCount;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void whiteDfs(int x, int y) {

        // 방문 처리하고, 병사의 수를 증가시킨다.
        visited[x][y] = true;
        whiteCount++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }

            if (graph[nx][ny] == 'W' && !visited[nx][ny]) {
                whiteDfs(nx, ny);
            }
        }

    }

    private static void blueDfs(int x, int y) {

        // 방문 처리하고, 병사의 수를 증가시킨다.
        visited[x][y] = true;
        blueCount++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }

            if (graph[nx][ny] == 'B' && !visited[nx][ny]) {
                blueDfs(nx, ny);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String input = br.readLine();

            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        int blue = 0, white = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 흰색 병사이고, 방문하지 않았을 때 dfs 탐색
                if (graph[i][j] == 'W' && !visited[i][j]) {
                    whiteCount = 0;
                    whiteDfs(i, j);

                    // 흰색 병사의 위력
                    white += (int) Math.pow(whiteCount, 2);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 파란색 병사이고, 방문하지 않았을 때 dfs 탐색
                if (graph[i][j] == 'B' && !visited[i][j]) {
                    blueCount = 0;
                    blueDfs(i, j);

                    // 파란색 병사의 위력
                    blue += (int) Math.pow(blueCount, 2);
                }
            }
        }

        bw.write(white + " " + blue);
        bw.flush();
        bw.close();
    }
}