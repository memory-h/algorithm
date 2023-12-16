package dfs.silver.silver_2;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _2210 {

    static int[][] graph;
    static HashSet<String> set;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void dfs(int x, int y, int depth, String str) {

        // 탐색 깊이가 6일 때 Set에 str를 넣는다. (중복 제거)
        if (depth == 6) {
            set.add(str);

            return;
        }

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int x1 = dx[i] + x;
            int y1 = dy[i] + y;

            if (x1 < 0 || y1 < 0 || x1 >= 5 || y1 >= 5) {
                continue;
            }

            dfs(x1, y1, depth + 1, str + graph[x1][y1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        graph = new int[5][5];
        set = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String str = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                dfs(i, j, 0, str);
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }
}