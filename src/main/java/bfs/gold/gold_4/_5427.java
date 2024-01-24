package bfs.gold.gold_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5427 {

    static int w, h;
    static char[][] graph;
    static Queue<int[]> queue;
    static Queue<int[]> fire;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new char[h][w];
            queue = new LinkedList<>();
            fire = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String input = br.readLine();

                for (int j = 0; j < w; j++) {
                    graph[i][j] = input.charAt(j);

                    // 상근이의 시작 위치 저장
                    if (graph[i][j] == '@') {
                        queue.offer(new int[]{i, j, 0});
                    }

                    // 불의 위치 저장
                    if (graph[i][j] == '*') {
                        fire.offer(new int[]{i, j});
                    }
                }
            }

            sb.append(bfs()).append("\n");
        }

        bw.write(sb.toString());
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

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        continue;
                    }

                    if (graph[nx][ny] == '.') {
                        graph[nx][ny] = '*';
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

                    // 범위를 벗어나게 되면 빌딩을 탈출
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        return String.valueOf(now[2] + 1);
                    }

                    if (graph[nx][ny] == '.') {
                        graph[nx][ny] = '@';
                        queue.offer(new int[]{nx, ny, now[2] + 1});
                    }
                }
            }

        }

        // 빌딩을 탈출할 수 없는 경우
        return "IMPOSSIBLE";
    }

}