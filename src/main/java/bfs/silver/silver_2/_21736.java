package bfs.silver.silver_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _21736 {

    private static int n;
    private static int m;

    private static char[][] graph;
    private static boolean[][] visited;
    private static Queue<int[]> queue;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        visited = new boolean[n][m];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j);

                if (graph[i][j] == 'I') {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        bw.write(bfs());
        bw.flush();
        bw.close();
    }

    private static String bfs() {
        int count = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || graph[nx][ny] == 'X') {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (graph[nx][ny] == 'P') {
                        count++;
                    }

                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return count == 0 ? "TT" : String.valueOf(count);
    }

}