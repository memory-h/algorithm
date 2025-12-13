package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3184 {

    private static int r, c;
    private static int sheepCount, wolfCount;

    private static char[][] graph;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String input = br.readLine();

            for (int j = 0; j < c; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && graph[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        bw.write(sheepCount + " " + wolfCount);
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        visited[x][y] = true;

        int vCount = 0;
        int oCount = 0;

        if (graph[x][y] == 'v') {
            vCount++;
        } else if (graph[x][y] == 'o') {
            oCount++;
        }

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c || graph[nx][ny] == '#') {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (graph[nx][ny] == 'v') {
                        vCount++;
                    } else if (graph[nx][ny] == 'o') {
                        oCount++;
                    }
                    queue.offer(new Position(nx, ny));
                }
            }
        }

        if (vCount >= oCount) {
            wolfCount += vCount;
        } else {
            sheepCount += oCount;
        }
    }

    private static class Position {

        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}