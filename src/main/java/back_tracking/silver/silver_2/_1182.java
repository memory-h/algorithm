package back_tracking.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _1182 {

    static int n, s, count = 0;
    static int[] arr;
    static int[] cache;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        cache = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (s == 0) bw.write(String.valueOf(count - 1));
        else bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int sum) {

        if (depth == n) {
            if (sum == s) {
                count++;
            }

            return;
        }

        // 원소를 선택했을 때
        dfs(depth + 1, sum + arr[depth]);

        // 원소를 선택하지 않았을 때
        dfs(depth + 1, sum);

    }

}