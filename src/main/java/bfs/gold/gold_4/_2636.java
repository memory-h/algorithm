package bfs.gold.gold_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2636 {

    static int n, m, cheese;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        cheese = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == 1) cheese++;
            }
        }

        int result = 0;
        int time = 0;

        while (cheese != 0) {
            visited = new boolean[n][m];
            result = cheese; // 치즈의 개수 저장
            bfs();
            time++; // 탐색이 끝난 후 시간 증가
        }

        bw.write(time + "\n" + result);
        bw.flush();
        bw.close();
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;

                    // 공기와 접촉된 치즈는 한 시간이 지나면 녹아 없어진다.
                    if (graph[nx][ny] == 1) {
                        cheese--;
                        graph[nx][ny] = 0;
                    }
                    else {
                        queue.offer(new int[]{nx, ny});
                    }
                }

            }
        }

    }

}