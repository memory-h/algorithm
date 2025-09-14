package dfs.silver.silver_4;

import java.io.*;
import java.util.StringTokenizer;

public class _16173 {

    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        boolean result = dfs(0, 0);

        bw.write(result ? "HaruHaru" : "Hing");
        bw.flush();
        bw.close();
    }

    private static boolean dfs(int x, int y) {
        if (x == n - 1 && y == n - 1) {
            return true;
        }

        if (x + arr[x][y] < n && !visited[x + arr[x][y]][y]) {
            visited[x + arr[x][y]][y] = true;
            if (dfs(x + arr[x][y], y)) {
                return true;
            }
        }

        if (y + arr[x][y] < n && !visited[x][y + arr[x][y]]) {
            visited[x][y + arr[x][y]] = true;
            if (dfs(x, y + arr[x][y])) {
                return true;
            }
        }

        return false;
    }

}