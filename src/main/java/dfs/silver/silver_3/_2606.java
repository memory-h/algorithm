package dfs.silver.silver_3;

import java.io.*;
import java.util.*;

public class _2606 {

    private static int n;
    private static int[][] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        int computerCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < computerCount; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        int result = bfs();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int next = 1; next <= n; next++) {
                if (!visited[next] && arr[currentNode][next] == 1) {
                    visited[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }

        return count;
    }

}