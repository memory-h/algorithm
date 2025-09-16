package bfs.silver.silver_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _25418 {

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[k + 1];

        int count = bfs(a, k);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static int bfs(int a, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, 0});
        visited[a] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == k) {
                return cur[1];
            }

            if (cur[0] + 1 <= k && !visited[cur[0] + 1]) {
                visited[cur[0] + 1] = true;
                queue.add(new int[]{cur[0] + 1, cur[1] + 1});
            }

            if (cur[0] * 2 <= k && !visited[cur[0] * 2]) {
                visited[cur[0] * 2] = true;
                queue.add(new int[]{cur[0] * 2, cur[1] + 1});
            }
        }

        return 0;
    }

}