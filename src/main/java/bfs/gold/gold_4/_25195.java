package bfs.gold.gold_4;

import java.io.*;
import java.util.*;

public class _25195 {

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
        }

        int s = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < s; i++) {
            int fanclub = Integer.parseInt(st.nextToken());
            visited[fanclub] = true;
        }

        bw.write(bfs());
        bw.flush();
        bw.close();
    }

    private static String bfs() {

        // 팬클럽 곰곰이가 시작 정점에 있으면 무조건 만나게 되므로 Yes
        if (visited[1]) {
            return "Yes";
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // 팬클럽 곰곰이를 만나지 않고 이동하는 방법이 존재할 때
            if (graph.get(node).isEmpty()) {
                return "yes";
            }

            for (int value : graph.get(node)) {
                if (!visited[value]) {
                    visited[value] = true;
                    queue.add(value);
                }
            }
        }

        return "Yes";
    }

}