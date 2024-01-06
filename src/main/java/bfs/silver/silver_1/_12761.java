package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _12761 {

    static int a, b, n, m, result;
    static boolean[] visited;

    private static void bfs(int start) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            // 8가지 이동 방법 저장
            int[] move = {now[0] + 1, now[0] - 1, now[0] + a, now[0] - a, now[0] +  b, now[0] - b, now[0] * a, now[0] * b};

            // 주미에게 도달하면 result에 저장하고 종료
            if (now[0] == m) {
                result = now[1];
                return;
            }

            for (int i = 0; i < 8; i++) {
                int position = move[i];

                if (position < 0 || position > 100000 || visited[position]) {
                    continue;
                }

                visited[position] = true;
                queue.offer(new int[]{position, now[1] + 1});
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        result = 0;

        // 동규의 현재 위치부터 bfs 탐색 시작
        bfs(n);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}