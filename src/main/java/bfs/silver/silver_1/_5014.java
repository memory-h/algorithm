package bfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _5014 {

    private static int f, s, g;

    private static int[] dx;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = -Integer.parseInt(st.nextToken());

        dx = new int[] {u, d};
        visited = new boolean[1000001];

        String result = bfs(s, g);

        bw.write(result);
        bw.flush();
        bw.close();
    }

    private static String bfs(int startNode, int endNode) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(startNode, 0));
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            if (position.curFloor == endNode) {
                return String.valueOf(position.depth);
            }

            for (int i = 0; i < dx.length; i++) {
                int cFloor = position.curFloor + dx[i];

                if (cFloor <= 0 || cFloor > f) {
                    continue;
                }

                if (!visited[cFloor]) {
                    visited[cFloor] = true;
                    queue.offer(new Position(cFloor, position.depth + 1));
                }
            }
        }

        return "use the stairs";
    }

    private static class Position {

        private final int curFloor;
        private final int depth;

        public Position(int curFloor, int depth) {
            this.curFloor = curFloor;
            this.depth = depth;
        }

    }

}