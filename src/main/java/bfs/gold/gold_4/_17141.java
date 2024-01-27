package bfs.gold.gold_4;

import java.io.*;
import java.util.*;

public class _17141 {

    static int n, m, min = Integer.MAX_VALUE;
    static int[][] graph;
    static int[] arr;
    static List<Virus> list;
    static boolean[] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                // 바이러스 저장
                if (graph[i][j] == 2) {
                    list.add(new Virus(i, j, 0));
                }
            }
        }

        arr = new int[m];
        visited = new boolean[list.size()];

        combination(0, 0);

        if (min == Integer.MAX_VALUE) bw.write("-1");
        else bw.write(String.valueOf(min));

        bw.flush();
        bw.close();
    }

    // Combination 알고리즘을 이용하여 바이러스를 놓을 수 있는 칸을 구한다.
    private static void combination(int depth, int start) {

        if (depth == m) {
            bfs();
            return;
        }

        for (int i = start; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                combination(depth + 1, i + 1);
                visited[i] = false;
            }
        }

    }

    private static void bfs() {

        Queue<Virus> queue = new LinkedList<>();
        int[][] virus = new int[n][n];

        int time = 0;

        copyVirus(virus);

        // 바이러스 위치 저장
        for (int i = 0; i < m; i++) {
            queue.offer(list.get(arr[i]));
            virus[list.get(arr[i]).x][list.get(arr[i]).y] = 2;
        }

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Virus now = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + now.x;
                    int ny = dy[j] + now.y;

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }

                    if (virus[nx][ny] == 0) {
                        virus[nx][ny] = 2;
                        queue.offer(new Virus(nx, ny, now.time + 1));
                    }
                }
                time = now.time;
            }
        }

        // 모든 빈칸에 바이러스를 퍼뜨릴 수 있을 때
        if (isVirusCheck(virus)) {
            min = Math.min(min, time);
        }

    }

    private static void copyVirus(int[][] virus) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 2) {
                    virus[i][j] = graph[i][j];
                }
                else {
                    virus[i][j] = 0;
                }
            }
        }
    }

    private static boolean isVirusCheck(int[][] virus) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (virus[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    static class Virus {
        private final int x;
        private final int y;
        private final int time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

}