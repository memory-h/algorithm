package back_tracking.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _26170 {

    static int r, c, result = Integer.MAX_VALUE;
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
        dfs(r, c, 0, 0);

        bw.write(String.valueOf(result == Integer.MAX_VALUE ? -1 : result));
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y, int apple, int count) {

        // 사과 3개를 먹은 경우
       if (apple == 3) {
           result = Math.min(result, count);

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
               dfs(nx, ny, apple + (graph[nx][ny] == 1 ? 1 : 0), count + 1);

               visited[nx][ny] = false;
           }
       }

    }

}