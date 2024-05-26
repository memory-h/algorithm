package dfs.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _6080 {

    static int r, c;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < c; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 방문하지 않았거나, 맛있는 풀이 아닌 경우
                if (!visited[i][j] && graph[i][j] != 0) {
                    visited[i][j] = true;
                    dfs(i, j); // dfs 탐색
                    count++; // 나쁜 풀 섬의 개수 증가
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        br.close();
    }

    private static void dfs(int x, int y) {

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }

            if (!visited[nx][ny] && graph[nx][ny] != 0) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }

    }

}