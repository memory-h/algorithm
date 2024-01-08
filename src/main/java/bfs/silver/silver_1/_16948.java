package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16948 {

    static int n, r1, c1, r2, c2, result;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 1});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                // 데스 나이트가 해당 좌표에 이동 가능하면 result에 저장하고 return
                if (nx == r2 && ny == c2) {
                    result = now[2];
                    return;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, now[2] + 1});
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        visited = new boolean[n][n];

        // 이동할 수 없는 경우에는 -1 출력
        result = -1;

        // (r1, c1) 부터 bfs 탐색 시작
        bfs(r1, c1);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}