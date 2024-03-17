package bfs.silver.silver_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _25418 {

    static int a, k, result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[1000001];

        bfs();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, 0});
        visited[a] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            // a가 k와 같아지는 경우
            if (now[0] == k) {
                result = now[1];

                return;
            }

            // 연산 2: 정수 a에 2를 곱한다.
            if (now[0] * 2 <= k && !visited[now[0] * 2]) {
                visited[now[0] * 2] = true;
                queue.add(new int[]{now[0] * 2, now[1] + 1});
            }

            // 연산 1: 정수 a에 1을 더한다.
            if (now[0] + 1 <= k && !visited[now[0] + 1]) {
                visited[now[0] + 1] = true;
                queue.add(new int[]{now[0] + 1, now[1] + 1});
            }
        }

    }

}