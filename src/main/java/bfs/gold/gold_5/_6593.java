package bfs.gold.gold_5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6593 {

    static int l, r, c;
    static char[][][] graph;
    static boolean[][][] visited;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;

            graph = new char[l][r][c];
            visited = new boolean[l][r][c];

            int startZ = 0;
            int startX = 0;
            int startY = 0;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String input = br.readLine();

                    for (int k = 0; k < c; k++) {
                        graph[i][j][k] = input.charAt(k);

                        // 시작 지점 저장
                        if (graph[i][j][k] == 'S') {
                            startZ = i;
                            startX = j;
                            startY = k;
                        }
                    }
                }
                br.readLine();
            }

            sb.append(bfs(startZ, startX, startY)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static String bfs(int z, int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{z, x, y, 0});
        visited[z][x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nz = dz[i] + now[0];
                int nx = dx[i] + now[1];
                int ny = dy[i] + now[2];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= l || nx >= r || ny >= c || graph[nz][nx][ny] == '#') {
                    continue;
                }

                if (graph[nz][nx][ny] == 'E') {
                    return "Escaped in " + (now[3] + 1) + " minute(s).";
                }

                if (!visited[nz][nx][ny]) {
                    visited[nz][nx][ny] = true;
                    queue.offer(new int[]{nz, nx, ny, now[3] + 1});
                }
            }

        }

        return "Trapped!";
    }

}