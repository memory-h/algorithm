package back_tracking.silver.silver_3;

import java.io.*;

public class _16922 {

    static int n, count = 0;
    static int[] number = {1, 5, 10, 50};
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[1001];

        dfs(0, 0, 0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int sum, int index) {

        if (depth == n) {
            // Set을 사용하면 시간 초과가 발생하기 때문에 boolean[] 배열로 중복을 제거한다.
            if (!visited[sum]) {
                visited[sum] = true;
                count++;
            }

            return;
        }

        for (int i = index; i < 4; i++) {
            dfs(depth + 1, sum + number[i], i);
        }

    }

}