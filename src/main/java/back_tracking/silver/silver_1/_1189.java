package back_tracking.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _1189 {

    static int r, c, k, count = 0;
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
        k = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        visited = new boolean[r][c];
        visited[r - 1][0] = true;

        for (int i = 0; i < r; i++) {
            String input = br.readLine();

            for (int j = 0; j < c; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        dfs(r - 1, 0, 1);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y, int depth) {

        // 거리가 k 일 때 집에 도착한 경우
        if (depth == k) {
            if (x == 0 && y == c - 1) {
                count++;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            // 범위가 벗어나거나 T인 경우
            if (nx < 0 || ny < 0 || nx >= r || ny >= c || graph[nx][ny] == 'T') {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1);
                visited[nx][ny] = false;
            }
        }

    }

}