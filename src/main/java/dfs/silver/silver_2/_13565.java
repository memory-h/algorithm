package dfs.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _13565 {

    static int m, n;
    static boolean check;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void dfs(int x, int y) {

        if (x == m - 1) {
            check = true;

            return;
        }

        for (int i = 0; i < 4; i++) {
            int x1 = dx[i] + x;
            int y1 = dy[i] + y;

            if (x1 < 0 || y1 < 0 || x1 >= m || y1 >= n) {
                continue;
            }

            if (graph[x1][y1] == 0 && !visited[x1][y1]) {
                visited[x1][y1] = true;
                dfs(x1, y1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String input = br.readLine();

            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        // graph[0][i] 부터 graph[m - 1][i] 까지 전류가 침투될 수 있는지 dfs로 구한다.
        for (int i = 0; i < n && !check; i++) {
            if (graph[0][i] == 0 && !visited[0][i]) {
                dfs(0, i);
            }
        }

        if (check) bw.write("YES");
        else bw.write("NO");

        bw.flush();
        bw.close();
    }
}