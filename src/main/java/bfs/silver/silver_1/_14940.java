package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14940 {

    static int n, m;
    static int[][] graph;
    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        result[x][y] = 0;
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            // 가로, 세로 탐색
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || graph[nx][ny] == 0) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    result[nx][ny] = now[2] + 1; // 목표지점까지의 거리를 result 배열에 저장
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

        graph = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                // 목표지점 좌표 저장
                if (graph[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        // 목표지점부터 bfs 탐색 시작
        bfs(startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 땅인 부분 중에서 도달할 수 없는 위치
                if (graph[i][j] == 1 && result[i][j] == 0) {
                    sb.append(-1).append(" ");
                }
                else {
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}