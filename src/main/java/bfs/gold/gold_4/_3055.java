package bfs.gold.gold_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3055 {

    static int r, c;
    static char[][] graph;
    static Queue<int[]> queue;
    static Queue<int[]> water;

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
        water = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String input = br.readLine();

            for (int j = 0; j < c; j++) {
                graph[i][j] = input.charAt(j);

                // 고슴도치 위치 저장
                if (graph[i][j] == 'S') {
                    queue.offer(new int[]{i, j, 0});
                }

                // 물이 차있는 지역 저장
                if (graph[i][j] == '*') {
                    water.offer(new int[]{i, j});
                }
            }
        }

        bw.write(bfs());
        bw.flush();
        bw.close();
    }

    private static String bfs() {

        while (!queue.isEmpty()) {

            int waterSize = water.size();

            for (int i = 0; i < waterSize; i++) {
                int[] now = water.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + now[0];
                    int ny = dy[j] + now[1];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        continue;
                    }

                    // 물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다.
                    if (graph[nx][ny] == '.') {
                        graph[nx][ny] = '*';
                        water.offer(new int[]{nx, ny});
                    }
                }
            }

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + now[0];
                    int ny = dy[j] + now[1];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        continue;
                    }

                    if (graph[nx][ny] == 'D') {
                        return String.valueOf(now[2] + 1);
                    }

                    // 고슴도치 이동
                    if (graph[nx][ny] == '.') {
                        graph[nx][ny] = 'S';
                        queue.offer(new int[]{nx, ny, now[2] + 1});
                    }
                }
            }

        }

        return "KAKTUS";
    }

}