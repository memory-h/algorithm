package bfs.silver.silver_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14248 {

    static int n, count;
    static int[] graph;
    static boolean[] visited;
    static int[] dx = {1, -1}; // 좌, 우 이동 가능

    private static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int pos = queue.poll();

            for (int i = 0; i < 2; i++) {
                int nx = pos + (dx[i] * graph[pos]);

                if (nx < 0 || nx >= n) {
                    continue;
                }

                if (!visited[nx]) {
                    visited[nx] = true;
                    queue.offer(nx);
                    count++;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) graph[i] = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(br.readLine());

        count = 1;

        // 출발점부터 bfs 탐색 시작
        bfs(s - 1);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}