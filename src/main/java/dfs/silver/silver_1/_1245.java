package dfs.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _1245 {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static boolean check;
    static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};

    private static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || graph[nx][ny] == 0) {
                continue;
            }

            // 산봉우리가 아닐 때
            if (graph[nx][ny] > graph[x][y]){
                check = false;
            }

            if (graph[x][y] == graph[nx][ny] && !visited[nx][ny]) {
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

        graph= new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    check = true;
                    dfs(i, j);

                    // 산봉우리 개수 증가
                    if (check) count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}