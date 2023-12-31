package bfs.silver.silver_2;

import java.io.*;
import java.util.*;

public class _14496 {

    static int a, b, n, m;
    static List<Integer>[] graph;
    static boolean[] visited;

    /** 가중치가 없는 최단경로 구하는 문제 : BFS */
    private static String bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, 0});
        visited[a] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == b) {
                return String.valueOf(now[1]);
            }

            for (Integer i : graph[now[0]]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(new int[]{i, now[1] + 1});
                }
            }
        }

        return "-1";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 연결
            graph[u].add(v);
            graph[v].add(u);
        }

        bw.write(bfs());
        bw.flush();
        bw.close();
    }
}