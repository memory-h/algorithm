package bfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _14562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            sb.append(bfs(s, t)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs(int startNode, int endNode) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(startNode, endNode, 0));

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            if (position.curNode == position.endNode) {
                return position.kickingCount;
            }

            if (position.curNode * 2 <= position.endNode + 3) {
                queue.offer(new Position(position.curNode * 2, position.endNode + 3, position.kickingCount + 1));
            }

            if (position.curNode + 1 <= position.endNode) {
                queue.offer(new Position(position.curNode + 1, position.endNode, position.kickingCount + 1));
            }
        }

        return 0;
    }

    private static class Position {

        private final int curNode;
        private final int endNode;
        private final int kickingCount;

        public Position(int curNode, int endNode, int kickingCount) {
            this.curNode = curNode;
            this.endNode = endNode;
            this.kickingCount = kickingCount;
        }

    }

}