package back_tracking.silver.silver_3;

import java.io.*;
import java.util.StringTokenizer;

public class _26169 {

    static int r, c;
    static String result = "0";
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        graph = new int[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited[r][c] = true;
        dfs(0, r, c, 0);

        bw.write(result);
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int x, int y, int apple) {

        // 세 번 이하의 이동으로
        if (depth == 3) {
            // 사과 2개 이상 먹을 수 있는 경우
            if (apple >= 2) {
                result = "1";
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || graph[nx][ny] == -1) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;

                // 사과를 찾은 경우 apple 개수 증가, 아니면 그대로 진행
                dfs(depth + 1, nx, ny, apple + (graph[nx][ny] == 1 ? 1 : 0));

                visited[nx][ny] = false;
            }
        }

    }

}