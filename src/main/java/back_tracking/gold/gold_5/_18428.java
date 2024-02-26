package back_tracking.gold.gold_5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18428 {

    static int n;
    static String result = "NO";
    static char[][] hallway;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        hallway = new char[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                hallway[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0);


        bw.write(result);
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth) {

        // 3개의 장애물을 놓을 위치를 선택한 후, bfs 탐색
        if (depth == 3) {
            if (bfs()) {
                result = "YES";
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hallway[i][j] == 'X') {
                    hallway[i][j] = 'O';
                    dfs(depth + 1);
                    hallway[i][j] = 'X';
                }
            }
        }

    }

    private static boolean bfs() {

        Queue<Position> queue = new LinkedList<>();
        char[][] copy = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = hallway[i][j];

                // 선생님 위치를 큐에 저장
                if (copy[i][j] == 'T') {
                    queue.add(new Position(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = position.x;
                int ny = position.y;

                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    // 범위를 벗어났을 때
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        break;
                    }

                    // 학생을 만나면 false 리턴
                    if (copy[nx][ny] == 'S') {
                        return false;
                    }

                    // 장애물을 만났을 때
                    if (copy[nx][ny] == 'O') {
                        break;
                    }
                }
            }
        }

        return true;
    }

    static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}