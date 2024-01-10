package bfs.gold.gold_5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2589 {

    static int n, m;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 육지를 나타내는 두 곳 사이를 최단 거리의 최대값을 구한다.
                if (graph[i][j] == 'L') {
                    visited = new boolean[n][m];
                    result = Math.max(result, bfs(i, j));
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;
        int temp = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    temp = Math.max(temp, now[2] + 1);
                    queue.offer(new int[]{nx, ny, now[2] + 1});
                }
            }
        }

        return temp;
    }

}