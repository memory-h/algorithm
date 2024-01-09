package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18404 {

    static int n, m, x, y;
    static int[][] result;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx < 1 || ny < 1 || nx > n || ny > n) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;

                    // 이동 횟수 저장
                    graph[nx][ny] = now[2] + 1;
                    queue.offer(new int[]{nx, ny, now[2] + 1});
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        result = new int[n + 1][n + 1];
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        // bfs 탐색 시작
        bfs(x, y);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 말의 위치까지 이동한 횟수를 StringBuilder에 저장
            sb.append(graph[a][b]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}