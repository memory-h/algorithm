package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16174 {

    static int n;
    static boolean result;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            // '쩰리’가 이동 가능한 방향은 오른쪽과 아래
            for (int i = 0; i < 2; i++) {
                int nx = node[0] + dx[i] * graph[node[0]][node[1]];
                int ny = node[1] + dy[i] * graph[node[0]][node[1]];

                // 게임 구역을 벗어나거나, 이미 방문한 구역일 때
                if (nx >= n || ny >= n || visited[nx][ny]) {
                    continue;
                }

                // ‘쩰리’가 끝 점에 도달했을 때
                if (graph[nx][ny] == -1) {
                    result = true;

                    return;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if (result) bw.write("HaruHaru");
        else bw.write("Hing");

        bw.flush();
        bw.close();
    }
}