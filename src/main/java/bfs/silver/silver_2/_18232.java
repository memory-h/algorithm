package bfs.silver.silver_2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18232 {

    static int n, m, s, e, result;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static int[] dx = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 텔레포트 양방향 설정
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs(s);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs(int x) {

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, 0));
        visited[x] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            if (position.x == e) {
                result = position.count;

                return;
            }

            // position.x에 위치한 텔레포트와 연결된 지점으로 이동
            for (int value : graph.get(position.x)) {
                if (!visited[value]) {
                    visited[value] = true;
                    queue.add(new Position(value, position.count + 1));
                }
            }

            // (position.x + 1) 또는 (position.x - 1) 이동
            for (int i = 0; i < 2; i++) {
                int nx = dx[i] + position.x;

                if (nx < 0 || nx > n) {
                    continue;
                }

                if (!visited[nx]) {
                    visited[nx] = true;
                    queue.add(new Position(nx, position.count + 1));
                }
            }
        }

    }

    static class Position {
        private final int x;
        private final int count;

        public Position(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

}