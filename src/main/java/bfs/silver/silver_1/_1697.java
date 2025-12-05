package bfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _1697 {

    private static boolean[] visited;

    private static int[] dx = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new  StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[200001];

        int result = bfs(n, k);

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
                return position.time;
            }

            for (int i = 0; i < dx.length; i++) {
                int nextNode;

                if (i == dx.length - 1) {
                    nextNode = position.curNode * dx[dx.length - 1];
                } else {
                    nextNode = position.curNode + dx[i];
                }

                if (nextNode < 0 || nextNode > 200000) {
                    continue;
                }

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(new Position(nextNode, position.time + 1));
                }
            }
        }

        return 0;
    }

    private static class Position {

        private final int curNode;
        private final int time;

        public Position(int curNode, int time) {
            this.curNode = curNode;
            this.time = time;
        }

    }

}