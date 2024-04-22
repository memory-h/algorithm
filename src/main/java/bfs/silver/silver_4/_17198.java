package bfs.silver.silver_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _17198 {

    static int result;
    static char[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        graph = new char[10][10];
        visited = new boolean[10][10];

        int barnX = 0;
        int barnY = 0;

        for (int i = 0; i < 10; i++) {
            String input = br.readLine();

            for (int j = 0; j < 10; j++) {
                graph[i][j] = input.charAt(j);

                // 헛간 위치 저장
                if (graph[i][j] == 'B') {
                    barnX = i;
                    barnY = j;
                }
            }
        }

        bfs(barnX, barnY);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {

        Queue<Farm> queue = new LinkedList<>();
        queue.add(new Farm(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Farm farm = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + farm.x;
                int ny = dy[i] + farm.y;

                // 범위를 벗어나거나 바위인 경우
                if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10 || graph[nx][ny] == 'R') {
                    continue;
                }

                // 호수를 찾은 경우 이동 경로 반환
                if (graph[nx][ny] == 'L') {
                    result = farm.count;

                    return;
                }

                // 이동 가능한 땅일 때 방문하지 않은 경우
                if (!visited[nx][ny] && graph[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    queue.add(new Farm(nx, ny, farm.count + 1));
                }
            }
        }

    }

    static class Farm {
        private final int x;
        private final int y;
        private final int count;

        public Farm(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}