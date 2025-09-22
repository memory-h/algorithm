package bfs.silver.silver_2;

import java.io.*;
//import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11060 {

    private static int n;
    private static int result = -1;

    private static int[] maze;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        maze = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == n - 1) {
                result = cur[1];
                return;
            }

            for (int i = cur[0] + 1; i <= cur[0] + maze[cur[0]] && i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[] {i, cur[1] + 1});
                }
            }
        }
    }

    /* Dynamic Programming */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[1001];
//        int[] dp = new int[1101];
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
//        Arrays.fill(dp, Integer.MAX_VALUE);
//
//        dp[1] = 0;
//        for(int i = 1; i <= n; i++) {
//            if (dp[i] == Integer.MAX_VALUE) continue;
//
//            for(int j = 1; j <= arr[i]; j++) {
//                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
//            }
//        }
//        if(dp[n] == Integer.MAX_VALUE) bw.write("-1");
//        else bw.write(String.valueOf(dp[n]));
//
//        bw.flush();
//        bw.close();
//    }

}