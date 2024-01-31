package bfs.gold.gold_5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13549 {

    static int n, k, time;
    static boolean[] visited;
    static int[] move = {2, -1, 1}; // 순서 중요!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        time = 0;

        bfs();

        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == k) {
                time = now[1];

                return;
            }

            int value;

            for (int i = 0; i < 3; i++) {
                if (i != 0) {
                    value = move[i] + now[0];
                }
                else {
                    value = move[i] * now[0];
                }

                if (value < 0 || value > 100000) {
                    continue;
                }

                if (!visited[value]) {
                    visited[value] = true;

                    // 2*X의 위치로 이동하는 경우
                    if (i == 0) {
                        queue.add(new int[]{value, now[1]});
                    }

                    // X-1 또는 X+1로 이동하는 경우
                    else {
                        queue.add(new int[]{value, now[1] + 1});
                    }
                }
            }
        }

    }

}