package back_tracking.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _10819 {

    static int n, result = 0;
    static int[] arr;
    static int[] cache;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        cache = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth) {

        if (depth == n) {
            int sum = 0;

            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(cache[i] - cache[i + 1]);
            }

            result = Math.max(result, sum);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cache[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }

    }

}