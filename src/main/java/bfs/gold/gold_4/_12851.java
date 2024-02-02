package bfs.gold.gold_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _12851 {

    static int n, k, time, count;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        time = 0; count = 0;

        bfs();

        bw.write(time + "\n" + count);
        bw.flush();
        bw.close();
    }

    private static void bfs() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            // 수빈이가 동생을 찾았을 때
            if (now == k) {
                if (count == 0) {
                    time = visited[now] - 1;
                }

                if (time == visited[now] - 1) {
                    count++;
                }

                continue;
            }

            int next = 0;

            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        next = now * 2;
                        break;

                    case 1:
                        next = now - 1;
                        break;

                    case 2:
                        next = now + 1;
                        break;
                }

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (isCheck(next, now)) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }

    }

    private static boolean isCheck(int next, int now) {
        // 처음 방문했거나, 이미 방문한 곳에 같은 시간으로 방문한 경우
        return visited[next] == 0 || visited[next] == visited[now] + 1;
    }

}