package dfs.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _11123 {

    private static int h;
    private static int w;

    private static char[][] graph;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph = new char[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String str = br.readLine();

                for (int j = 0; j < w; j++) {
                    graph[i][j] = str.charAt(j);
                }
            }

            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && graph[i][j] == '#') {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                continue;
            }

            if (!visited[nx][ny] && graph[nx][ny] == '#') {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

}