package back_tracking.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _14889 {

    static int n, min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int index) {

        if (depth == n / 2) {
            // 스타트 팀과 링크 팀의 능력치의 차이의 최솟값을 구한다.
            min = Math.min(min, team());

            return;
        }

        // 백트래킹을 통해 조합이 가능한 팀을 구한다.
        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }

    }

    private static int team() {
        int start = 0, link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // 스타트 팀 능력치
                if (visited[i] && visited[j]) {
                    start += (arr[i][j] + arr[j][i]);
                }
                // 링크 팀 능력치
                else if (!visited[i] && !visited[j]) {
                    link += (arr[i][j] + arr[j][i]);
                }
            }
        }

        return Math.abs(start - link);
    }

}