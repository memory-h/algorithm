package dfs.silver.silver_4;

import java.io.*;
import java.util.StringTokenizer;

public class _6186 {

    static int r, c;
    static char[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String input = br.readLine();

            for (int j = 0; j < c; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 잔디 덩어리가 있고, 방문하지 않았으면 방문 처리하고 dfs 탐색
                if (!visited[i][j] && graph[i][j] == '#') {
                    visited[i][j] = true;
                    dfs(i, j);
                    count++; // 풀 덩어리의 수 증가
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }

            if (!visited[nx][ny] && graph[nx][ny] == '#') {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }

    }

}