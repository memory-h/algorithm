package bfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _6118 {

    private static int n, m;

    private static List<List<Integer>> graph;
    private static int[] barn;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        barn = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int maxDepth = bfs(1);
        int hideBarn = 0;
        int barnDistance = 0;
        int maxBarnDepthCount = 0;

        for (int i = barn.length - 1; i >= 0; i--) {
            if (barn[i] == maxDepth) {
                hideBarn = i;
                barnDistance = barn[i];
                maxBarnDepthCount++;
            }
        }

        bw.write(hideBarn + " " + barnDistance + " " + maxBarnDepthCount);
        bw.flush();
        bw.close();
    }

    private static int bfs(int startNode) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(startNode, 0));
        visited[startNode] = true;
        int maxDepth = 0;

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            maxDepth = Math.max(maxDepth, position.depth);

            for (int nextNode : graph.get(position.curNode)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    barn[nextNode] = position.depth + 1;
                    queue.offer(new Position(nextNode, position.depth + 1));
                }
            }
        }

        return maxDepth;
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