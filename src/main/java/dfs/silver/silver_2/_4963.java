package dfs.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _4963 {

    private static int w;
    private static int h;

    private static int[][] graph;
    private static boolean[][] visited;

    private static int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
    private static int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            graph = new int[h + 1][w + 1];
            visited = new boolean[h + 1][w + 1];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && graph[i][j] == 1) {
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
        for (int i = 0; i < 8; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx < 0 || cy < 0 || cx >= h || cy >= w) {
                continue;
            }

            if (!visited[cx][cy] && graph[cx][cy] == 1) {
                visited[cx][cy] = true;
                dfs(cx, cy);
            }
        }
    }

}