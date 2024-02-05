package bfs.gold.gold_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14442 {

    static int n, m, k;
    static int[][] graph;
    static boolean[][][] visited;

    static int[] dx = {1 ,0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        // 현재 벽을 부순 개수를 추가하여 방문 처리한다.
        visited = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        bw.write(bfs());
        bw.flush();
        bw.close();
    }

    private static String bfs() {

        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Move move = queue.poll();

            if (move.x == n - 1 && move.y == m - 1) {
                return String.valueOf(move.count);
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + move.x;
                int ny = dy[i] + move.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 벽이 아닐 때
                if (graph[nx][ny] == 0 && !visited[nx][ny][move.wall]) {
                    visited[nx][ny][move.wall] = true;
                    queue.add(new Move(nx, ny, move.wall, move.count + 1));
                }

                // 벽일 때 `(현재 벽을 부순 개수) < k` 조건을 만족시킬 때
                if (graph[nx][ny] == 1 && move.wall < k && !visited[nx][ny][move.wall + 1]) {
                    visited[nx][ny][move.wall + 1] = true;
                    queue.add(new Move(nx, ny, move.wall + 1, move.count + 1));
                }
            }
        }

        return "-1";
    }

    static class Move {
        private final int x;
        private final int y;
        private final int wall;
        private final int count;

        public Move(int x, int y, int wall, int count) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.count = count;
        }
    }

}
// https://www.acmicpc.net/board/view/27386