package bfs.silver.silver_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17086 {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};

    private static int bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        visited = new boolean[n][m];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                int distance = now[2];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
                    continue;
                }

                // 아기 상어와 만났으면 거리 1을 추가하고 return
                if (graph[nx][ny] == 1) return distance + 1;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, distance + 1});

            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // n * m 크기의 공간에 아기 상어가 아닐 때
                if (graph[i][j] != 1) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}