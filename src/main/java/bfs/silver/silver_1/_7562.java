package bfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _7562 {

    private static int l;

    private static boolean[][] visited;

    private static int[] dx = {2, 1, 2, 1, -2, -1, -2, -1};
    private static int[] dy = {1, 2, -1, -2, 1, 2, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            l = Integer.parseInt(br.readLine());

            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int moveCount = bfs(startX, startY, endX, endY);

            sb.append(moveCount).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs(int startX, int startY, int endX, int endY) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            if (position.x == endX && position.y == endY) {
                return position.depth;
            }

            for (int i = 0; i < 8; i++) {
                int cx = position.x + dx[i];
                int cy = position.y + dy[i];

                if (cx < 0 || cy < 0 || cx >= l || cy >= l) {
                    continue;
                }

                if (!visited[cx][cy]) {
                    visited[cx][cy] = true;
                    queue.offer(new Position(cx, cy, position.depth + 1));
                }
            }
        }

        return 0;
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