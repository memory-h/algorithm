package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14716 {

    static int m, n;
    static int[][] graph;
    static boolean[][] visited;

    // 상, 하, 좌, 우, 대각선
    static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + node[0];
                int ny = dy[i] + node[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // bfs 탐색하여 현수막에 있는 글자의 개수를 찾는다.
                if (graph[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}