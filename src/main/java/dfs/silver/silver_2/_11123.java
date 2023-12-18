package dfs.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _11123 {

    static int h, w;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int x1 = dx[i] + x;
            int y1 = dy[i] + y;

            // 그리드의 범위를 벗어났을 때
            if (x1 < 0 || y1 < 0 || x1 >= h || y1 >= w) {
                continue;
            }

            // # 이면서 방문하지 않았을 때
            if (graph[x1][y1] == '#' && !visited[x1][y1]) {
                visited[x1][y1] = true;
                dfs(x1, y1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph = new char[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String input = br.readLine();

                for (int j = 0; j < w; j++) {
                    graph[i][j] = input.charAt(j);
                }
            }
            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {

                    // # 이면서 방문하지 않았을 때, dfs 탐색
                    if (graph[i][j] == '#' && !visited[i][j]) {
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
}