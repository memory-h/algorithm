package bfs.silver.silver_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _25416 {

    static int r, c;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        graph = new int[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 학생의 현재 위치(r, c)부터 bfs 탐색 시작
        int result = bfs(r, c);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int bfs(int x, int y) {

        Queue<Board> queue = new LinkedList<>();
        queue.add(new Board(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Board board = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + board.x;
                int ny = dy[i] + board.y;

                // 범위를 벗어나거나 이동할 수 없는 칸인 경우
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || graph[nx][ny] == -1) {
                    continue;
                }

                // 1이 적혀있는 칸에 도착하면 이동 횟수를 return
                if (graph[nx][ny] == 1) {
                    return board.count + 1;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Board(nx, ny, board.count + 1));
                }
            }

        }

        // 1이 적혀 있는 칸으로 이동할 수 없는 경우 -1 return
        return -1;
    }

    static class Board {
        private final int x;
        private final int y;
        private final int count;

        public Board(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}