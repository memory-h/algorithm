package bfs.gold.gold_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4179 {

    static int r, c;
    static char[][] graph;
    static Queue<int[]> queue;
    static Queue<int[]> fire;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        queue = new LinkedList<>();
        fire = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String input = br.readLine();

            for (int j = 0; j < c; j++) {
                graph[i][j] = input.charAt(j);

                // 지훈이의 위치를 큐에 저장
                if (graph[i][j] == 'J') {
                    queue.offer(new int[]{i, j, 0});
                }

                // 불의 위치를 큐에 저장
                if (graph[i][j] == 'F') {
                    fire.offer(new int[]{i, j});
                }
            }
        }

        bw.write(bfs());
        bw.flush();
        bw.close();
    }

    private static String bfs() {

        while (!queue.isEmpty()) {

            int fireSize = fire.size();

            for (int i = 0; i < fireSize; i++) {
                int[] now = fire.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + now[0];
                    int ny = dy[j] + now[1];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        continue;
                    }

                    if (graph[nx][ny] == '.') {
                        graph[nx][ny] = 'F';
                        fire.offer(new int[]{nx, ny});
                    }

                }
            }

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + now[0];
                    int ny = dy[j] + now[1];

                    // 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출 시간 return
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        return String.valueOf(now[2] + 1);
                    }

                    if (graph[nx][ny] == '.') {
                        graph[nx][ny] = 'J';
                        queue.offer(new int[]{nx, ny, now[2] + 1});
                    }
                }
            }

        }

        // 미로를 탈출할 수 없는 경우
        return "IMPOSSIBLE";
    }

}