package bfs.gold.gold_4;

import java.io.*;
import java.util.PriorityQueue;

public class _2665 {

    static int n, result = 0;
    static char[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        graph = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        bfs();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs() {

        // 우선순위 큐를 사용하여 이동할 때 벽을 가장 적게 부순 것부터 찾아서 탐색한다.
        PriorityQueue<Maze> pq = new PriorityQueue<>();
        pq.add(new Maze(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Maze maze = pq.poll();

            if (maze.x == n - 1 && maze.y == n - 1) {
                result = maze.count;

                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + maze.x;
                int ny = dy[i] + maze.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    // 벽이 아닌 경우
                    if (graph[nx][ny] == '1') {
                        visited[nx][ny] = true;
                        pq.add(new Maze(nx, ny, maze.count));
                    }
                    // 벽인 경우
                    else {
                        visited[nx][ny] = true;
                        pq.add(new Maze(nx, ny, maze.count + 1));
                    }
                }
            }
        }

    }

    static class Maze implements Comparable<Maze> {
        private final int x;
        private final int y;
        private final int count;

        public Maze(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Maze o) {
            return this.count - o.count;
        }
    }

}