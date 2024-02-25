package back_tracking.gold.gold_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15686 {

    static int n, m, result = Integer.MAX_VALUE;
    static int[][] arr;
    static List<Position> home;
    static List<Position> chicken;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    home.add(new Position(i, j));
                }
                if (arr[i][j] == 2) {
                    chicken.add(new Position(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        dfs(0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int index) {

        if (depth == m) {
            result = Math.min(result, getDistance());

            return;
        }

        // 백트래킹을 사용하여 치킨집을 선택하는 경우를 구한다.
        for (int i = index; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }

    }

    private static int getDistance() {

        int value = 0;

        for (Position position : home) {
            int temp = Integer.MAX_VALUE;

            for (int j = 0; j < chicken.size(); j++) {
                // 선택한 치킨집 일 때
                if (visited[j]) {
                    // 해당 집과 선택한 치킨집과의 거리의 최솟값을 구한다.
                    temp = Math.min(temp,
                            Math.abs(position.x - chicken.get(j).x) + Math.abs(position.y - chicken.get(j).y));
                }
            }

            value += temp;
        }

        return value;
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