package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17129 {

    static int n, m, distance = 0;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<int[]> queue;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j) - '0';

                // 윌리암슨수액빨이딱따구리 식구 위치 저장
                if (graph[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        // 청국장, 스시, 맥앤치즈 중 1개라도 먹을 수 있는 경우
        if (bfs()) {
            bw.write("TAK\n" + distance);
        }

        // 아무 음식도 먹을 수 없는 경우
        else {
            bw.write("NIE");
        }

        bw.flush();
        bw.close();
    }

    private static boolean bfs() {

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                // 범위를 벗어나거나, 벽인 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || graph[nx][ny] == 1) {
                    continue;
                }

                // 청국장, 스시, 맥앤치즈 중 1개라도 먹을 수 있는 경우 최단 거리 값을 저장 후 return
                if (graph[nx][ny] == 3 || graph[nx][ny] == 4 || graph[nx][ny] == 5) {
                    distance = now[2] + 1;

                    return true;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, now[2] + 1});
                }
            }
        }

        return false;
    }

}