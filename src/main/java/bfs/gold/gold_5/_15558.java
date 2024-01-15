package bfs.gold.gold_5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15558 {

    static int n, k;
    static char[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new char[2][n];
        visited = new boolean[2][n];

        for (int i = 0; i < 2; i++) {
            String input = br.readLine();

            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        bw.write(bfs());
        bw.flush();
        bw.close();
    }

    private static String bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();

                int[] dx = {now[0], now[0], (now[0] + 1) % 2};
                int[] dy = {1, -1, k};

                for (int j = 0; j < 3; j++) {
                    int nx = dx[j];
                    int ny = dy[j] + now[1];

                    // 범위를 벗어나거나, 없어진 칸에 이동한 경우
                    if (ny < 0 || ny == count) {
                        continue;
                    }

                    if (ny >= n) {
                        return "1";
                    }

                    if (!visited[nx][ny] && graph[nx][ny] == '1') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

            visited[0][count] = true;
            visited[1][count] = true;
            count++;
        }

        return "0";
    }

}