package dfs.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _21736 {

    static int n, m, count;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void dfs(int x, int y) {

        // 방문 처리
        visited[x][y] = true;

        // 도연이가 사람을 만나면 count 증가
        if (graph[x][y] == 'P') count++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (graph[nx][ny] != 'X' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        visited = new boolean[n][m];

        int xIndex = 0;
        int yIndex = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j);

                // 도연이의 위치를 찾는다.
                if (graph[i][j] == 'I') {
                    xIndex = i;
                    yIndex = j;
                }
            }
        }
        count = 0;

        // 도연이 위치부터 dfs 탐색
        dfs(xIndex, yIndex);

        if (count == 0) bw.write("TT");
        else bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}