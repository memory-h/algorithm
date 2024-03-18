package bfs.gold.gold_4;

import java.io.*;
import java.util.StringTokenizer;

public class _12886 {

    static int a, b, c;
    static String result = "0";
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new boolean[1501][1501];

        // 3개의 수를 더했을 때 3으로 나누어 떨어지지 않으면 돌을 같은 개수로 나눌 수 없다.
        if ((a + b + c) % 3 == 0) {
            dfs(a, b, c);
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }

    private static void dfs(int a, int b, int c) {

        // 3개의 수가 모두 같은 경우
        if (a == b && b == c) {
            result = "1";

            return;
        }

        compare(a, b, c);
        compare(b, c, a);
        compare(a, c, b);

    }

    private static void compare(int stone1, int stone2, int constant) {
        int newStone1 = Math.min(stone1, stone2); // 돌의 개수가 작은 쪽 : X
        int newStone2 = Math.max(stone1, stone2); // 돌의 개수가 큰 쪽 : Y

        if (!visited[newStone1 * 2][newStone2 - newStone1]) {
            visited[newStone1 * 2][newStone2 - newStone1] = true;
            dfs(newStone1 * 2, newStone2 - newStone1, constant);
        }
    }

}