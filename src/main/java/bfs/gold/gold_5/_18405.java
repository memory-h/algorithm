package bfs.gold.gold_5;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _18405 {

    static int n, k, s, x, y;
    static int[][] graph;
    static PriorityQueue<Virus> pq;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                // 바이러스 저장
                if (graph[i][j] != 0) {
                    pq.offer(new Virus(i, j, graph[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        bw.write(bfs());
        bw.flush();
        bw.close();
    }

    private static String bfs() {

        // s초 동안 진행
        for (int i = 0; i < s; i++) {
            // pq.offer(...)를 하게 되면, 우선순위가 계속 가장 작은 숫자로 잡히기 때문에 새로운 우선순위 큐를 만들어 사용한다.
            PriorityQueue<Virus> pqBfs = new PriorityQueue<>();
            int size = pq.size();

            for (int j = 0; j < size; j++) {
                while (!pq.isEmpty()) {
                    Virus now = pq.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k] + now.x;
                        int ny = dy[k] + now.y;

                        if (nx < 1 || ny < 1 || nx > n || ny > n) {
                            continue;
                        }

                        // 전염되지 않은 경우
                        if (graph[nx][ny] == 0) {
                            graph[nx][ny] = now.number;
                            pqBfs.offer(new Virus(nx, ny, now.number));
                        }
                    }
                }
            }
            pq = pqBfs;
        }

        return String.valueOf(graph[x][y]);
    }

    static class Virus implements Comparable<Virus> {
        int x;
        int y;
        int number;

        public Virus(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }

        @Override
        public int compareTo(Virus o) {
            return this.number - o.number;
        }
    }

}