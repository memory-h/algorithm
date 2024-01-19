package dfs.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _3187 {

    static int r, c, vCount, kCount;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void dfs(int x, int y) {

        visited[x][y] = true;
        if (graph[x][y] == 'k') kCount++;
        if (graph[x][y] == 'v') vCount++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= r || ny >= c || graph[nx][ny] == '#') {
                continue;
            }

            if (!visited[nx][ny]) {
                dfs(nx, ny);
            }
        }

    }

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

        int kResult = 0, vResult = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                kCount = 0; vCount = 0;

                if ((graph[i][j] == 'v' || graph[i][j] == 'k') && !visited[i][j]) {
                    dfs(i, j);

                    // 양의 수가 늑대의 수 보다 클 때
                    if (kCount > vCount) kResult += kCount;

                        // 양의 수가 늑대의 수 보다 작거나 같을 때
                    else vResult += vCount;
                }
            }
        }

        bw.write(kResult + " " + vResult);
        bw.flush();
        bw.close();
    }
}