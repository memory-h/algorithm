package bfs.silver.silver_1;

import java.io.*;
import java.util.*;

public class _2667 {

    private static int n;
    private static int[][] graph;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        List<Integer> apartmentComplexes = new ArrayList<>();
        int totalApartmentComplexCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    apartmentComplexes.add(bfs(i, j));
                    totalApartmentComplexCount++;
                }
            }
        }

        Collections.sort(apartmentComplexes);

        for (int apartmentComplex : apartmentComplexes) {
            sb.append(apartmentComplex).append("\n");
        }

        bw.write(totalApartmentComplexCount + "\n" + sb);
        bw.flush();
        bw.close();
    }

    private static int bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        visited[x][y] = true;
        int apartmentCount = 1;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    apartmentCount++;
                    queue.offer(new Position(nx, ny));
                }
            }
        }

        return apartmentCount;
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