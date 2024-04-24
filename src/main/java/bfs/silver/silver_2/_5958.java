package bfs.silver.silver_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _5958 {

    static int n;
    static char[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        graph = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 소행성 덩어리 일 때 방문하지 않은 경우
                if (!visited[i][j] && graph[i][j] == '*') {
                    bfs(i, j); // bfs 탐색
                    count++; // 소행성 개수 증가
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                // 범위를 벗어나거나 빈 공간인 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || graph[nx][ny] == '.') {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == '*') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

    }

}