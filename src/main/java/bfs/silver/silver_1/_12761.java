package bfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _12761 {

    private static boolean[] visited;
    private static int[] move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        move = new int[] {-1, 1, -a, -b, a, b, a, b};

        int result = bfs(n, m);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int bfs(int startNode, int endNode) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(startNode, 0));
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            if (position.curNode == endNode) {
                return position.depth;
            }

            for (int i = 0; i < 8; i++) {
                int cNode;

                if (i >= 6) {
                    cNode = position.curNode * move[i];
                } else {
                    cNode = position.curNode + move[i];
                }

                if (cNode < 0 || cNode > 100000) {
                    continue;
                }

                if (!visited[cNode]) {
                    visited[cNode] = true;
                    queue.offer(new Position(cNode, position.depth + 1));
                }
            }
        }

        return 0;
    }

    private static class Position {

        private final int curNode;
        private final int depth;

        public Position(int curNode, int depth) {
            this.curNode = curNode;
            this.depth = depth;
        }

    }

}