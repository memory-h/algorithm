package dfs.silver.silver_4;

import java.io.*;
import java.util.StringTokenizer;

public class _16173 {

    static int n;
    static boolean result;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    private static void dfs(int x, int y) {

        // ‘쩰리’가 끝 점에 도달했을 때
        if (graph[x][y] == -1) {
            result = true;

            return;
        }

        // '쩰리’가 이동 가능한 방향은 오른쪽과 아래
        for (int i = 0; i < 2; i++) {
            int nx = dx[i] * graph[x][y] + x;
            int ny = dy[i] * graph[x][y] + y;

            // 게임 구역을 벗어나거나, 이미 방문한 구역일 때
            if (nx >= n || ny >= n || visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;

            dfs(nx, ny);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        if (result) bw.write("HaruHaru");
        else bw.write("Hing");

        bw.flush();
        bw.close();
    }
}