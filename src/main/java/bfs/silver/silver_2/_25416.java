package bfs.silver.silver_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _25416 {

    private static int r, c;
    private static int[][] graph;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        graph = new int[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int result = bfs(r, c);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y, 0));

        while (!queue.isEmpty()) {
            Position curPosition = queue.poll();

            if (graph[curPosition.x][curPosition.y] == 1) {
                return curPosition.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curPosition.x + dx[i];
                int ny = curPosition.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || graph[nx][ny] == -1) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Position(nx, ny, curPosition.depth + 1));
                }
            }
        }

        return -1;
    }

    private static class Position {

        private final int x;
        private final int y;
        private final int depth;

        public Position(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

    }

}