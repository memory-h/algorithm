package bfs.silver.silver_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4677 {

    static int m, n;
    static char[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (m == 0) {
                break;
            }

            graph = new char[m][n];
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                String input = br.readLine();

                for (int j = 0; j < n; j++) {
                    graph[i][j] = input.charAt(j);
                }
            }

            int count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 오일 포켓을 찾았을 때 방문하지 않은 경우
                    if (!visited[i][j] && graph[i][j] == '@') {
                        bfs(i, j); // bfs 탐색
                        count++; // 석유 매장지 개수 증가
                    }
                }
            }

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            // 상하좌우 + 대각선 탐색
            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];

                // 범위를 벗어나거나 오일이 없는 경우
                if (nx < 0 || ny < 0 || nx >=m || ny >= n || graph[nx][ny] == '*') {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == '@') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

    }

}