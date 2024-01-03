package dfs.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _2468 {

    static int n, area, max;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            if (graph[nx][ny] > max && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        max = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, graph[i][j]);
            }
        }

        int result = 1;
        int temp = max;

        for (int k = 0; k < temp; k++) {
            // visited 배열 초기화
            visited = new boolean[n][n];
            area = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 해당 지점이 max보다 크고 방문하지 않았을 때 dfs 탐색
                    if (graph[i][j] > max && !visited[i][j]) {
                        dfs(i, j);
                        area++;
                    }
                }
            }
            // 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 구한다.
            result = Math.max(result, area);
            max--;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}