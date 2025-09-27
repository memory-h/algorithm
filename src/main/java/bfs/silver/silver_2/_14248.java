package bfs.silver.silver_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14248 {

    private static int n;
    private static int count;

    private static int[] stones;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        stones = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        bfs(s - 1);

        bw.write(String.valueOf(count + 1));
        bw.flush();
        bw.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int right = cur + stones[cur];
            int left = cur - stones[cur];

            if (right < n && !visited[right]) {
                visited[right] = true;
                queue.offer(right);
                count++;
            }

            if (left >= 0 && !visited[left]) {
                visited[left] = true;
                queue.offer(left);
                count++;
            }
        }
    }

}