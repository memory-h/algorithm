package bfs.gold.gold_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1600 {

    static int k, w, h;
    static int[][] graph;
    static boolean[][][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[] knightX = {1, 2, 1, 2, -1, -2, -1, -2};
    static int[] knightY = {2, 1, -2, -1, 2, 1, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph = new int[h][w];

        // 서로 다른 방법으로 이동했을 때 방문 처리를 따로 해줘야 한다.
        visited = new boolean[h][w][k + 1];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < w; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(bfs());
        bw.flush();
        bw.close();
    }

    private static String bfs() {

        Queue<Knight> queue = new LinkedList<>();
        queue.offer(new Knight(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Knight knight = queue.poll();

            if (knight.x == h - 1 && knight.y == w - 1) {
                return String.valueOf(knight.count);
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + knight.x;
                int ny = dy[i] + knight.y;

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    continue;
                }

                if (graph[nx][ny] == 0 && !visited[nx][ny][knight.move]) {
                    visited[nx][ny][knight.move] = true;
                    queue.offer(new Knight(nx, ny, knight.move, knight.count + 1));
                }
            }

            // 나이트의 이동 횟수가 k보다 작을 때
            if (knight.move < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = knightX[i] + knight.x;
                    int ny = knightY[i] + knight.y;

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        continue;
                    }

                    if (graph[nx][ny] == 0 && !visited[nx][ny][knight.move + 1]) {
                        visited[nx][ny][knight.move + 1] = true;
                        queue.offer(new Knight(nx, ny, knight.move + 1, knight.count + 1));
                    }
                }
            }

        }

        return "-1";
    }

    static class Knight {
        private final int x;
        private final int y;
        private final int move;
        private final int count;

        public Knight(int x, int y, int move, int count) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.count = count;
        }
    }

}