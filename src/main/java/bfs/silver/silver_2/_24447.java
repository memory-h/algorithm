package bfs.silver.silver_2;

import java.io.*;
import java.util.*;

public class _24447 {

    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int[][] nodeSequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        nodeSequence = new int[n + 1][2];

        for (int i = 0; i <= n; i ++) {
            nodeSequence[i][1] = -1;
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(r);

        long result = 0L;

        for (int i = 1; i <= n; i++) {
            result += (long) nodeSequence[i][0] * nodeSequence[i][1];
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs(int startNode) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startNode, 0});
        visited[startNode] = true;
        int sequence = 1;
        nodeSequence[startNode][0] = sequence++;
        nodeSequence[startNode][1] = 0;

        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();

            for (int nextNode : graph.get(curNode[0])) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    nodeSequence[nextNode][0] = sequence++;
                    nodeSequence[nextNode][1] = curNode[1] + 1;
                    queue.add(new int[]{nextNode, curNode[1] + 1});
                }
            }
        }
    }

}