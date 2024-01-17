package bfs.gold.gold_5;

import java.io.*;
import java.util.*;

public class _17836 {

    static int n, m, t;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(bfs());
        bw.flush();
        bw.close();
    }

    private static String bfs() {

        Queue<Sword> queue = new LinkedList<>();
        queue.offer(new Sword(0, 0, 0, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Sword sword = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + sword.x;
                int ny = dy[i] + sword.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 주어진 시간 이내에 공주를 찾은 경우
                if (sword.x == n - 1 && sword.y == m - 1) {
                    if (sword.time <= t) {
                        return String.valueOf(sword.time);
                    }
                }

                // 그람을 찾기 전
                if (!sword.isCheck) {
                    if (!visited[nx][ny][0] && graph[nx][ny] != 1) {
                        if (graph[nx][ny] == 2) {
                            sword.isCheck = true;
                        }
                        visited[nx][ny][0] = true;
                        queue.offer(new Sword(nx, ny, sword.time + 1, sword.isCheck));
                    }
                }
                // 그람을 찾은 후
                else {
                    if (!visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.offer(new Sword(nx, ny, sword.time + 1, sword.isCheck));
                    }
                }
            }
        }

        return "Fail";
    }

    static class Sword {
        int x;
        int y;
        int time;
        boolean isCheck;

        public Sword(int x, int y, int time, boolean isCheck) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.isCheck = isCheck;
        }
    }

}