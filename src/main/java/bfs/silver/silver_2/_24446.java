package bfs.silver.silver_2;

import java.io.*;
import java.util.*;

public class _24446 {

    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int[] nodeSequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        nodeSequence = new int[n + 1];

        Arrays.fill(nodeSequence, -1);

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

        bfs(r);

        for (int i = 1; i <= n; i++) {
            sb.append(nodeSequence[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int startNode) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startNode, 0});
        visited[startNode] = true;
        nodeSequence[startNode] = 0;

        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();

            for (int nextNode : graph.get(curNode[0])) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    nodeSequence[nextNode] = curNode[1] + 1;
                    queue.add(new int[]{nextNode, curNode[1] + 1});
                }
            }
        }
    }

}