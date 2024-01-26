package bfs.gold.gold_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16197 {

    static int n, m;
    static char[][] graph;
    static Queue<Coin> queue;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        queue = new LinkedList<>();

        int num = 0;
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j);

                if (graph[i][j] == 'o') {
                    if (num == 0) {
                        x = i;
                        y = j;
                        num++;
                    }
                    else {
                        queue.offer(new Coin(x, y, i, j, 0));
                    }
                }
            }
        }

        int result = bfs();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int bfs() {

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Coin coin = queue.poll();

            if (coin.count > 10) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx1 = dx[i] + coin.x1;
                int ny1 = dy[i] + coin.y1;
                int nx2 = dx[i] + coin.x2;
                int ny2 = dy[i] + coin.y2;

                boolean isCoin1Check = coinRange(nx1, ny1);
                boolean isCoin2Check = coinRange(nx2, ny2);

                // 동전 2개가 보드에서 떨어진 경우
                if (!isCoin1Check && !isCoin2Check) {
                    continue;
                }

                // 첫 번째 동전이 떨어진 경우
                if (!isCoin1Check && isCoin2Check) {
                    min = Math.min(min, coin.count + 1);
                    continue;
                }

                // 두 번째 동전이 떨어진 경우
                if (isCoin1Check && !isCoin2Check) {
                    min = Math.min(min, coin.count + 1);
                    continue;
                }

                if (graph[nx1][ny1] == '#' && graph[nx2][ny2] == '#') {
                    continue;
                }

                if (graph[nx1][ny1] == '#') {
                    nx1 = coin.x1;
                    ny1 = coin.y1;
                }

                if (graph[nx2][ny2] == '#') {
                    nx2 = coin.x2;
                    ny2 = coin.y2;
                }

                queue.offer(new Coin(nx1, ny1, nx2, ny2, coin.count + 1));
            }
        }

        return (min <= 10 ? min : -1);
    }

    private static boolean coinRange(int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < m);
    }

    static class Coin {
        private final int x1;
        private final int y1;
        private final int x2;
        private final int y2;
        private final int count;

        public Coin(int x1, int y1, int x2, int y2, int count) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
        }
    }

}