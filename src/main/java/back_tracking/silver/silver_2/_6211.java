package back_tracking.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _6211 {

    static int c, b;
    static int max = 0;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arr = new int[b];
        visited = new boolean[b];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < b; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int kcal) {

        // 칼로리가 c 이하인 경우
        if (kcal <= c) {
            max = Math.max(max, kcal);

            if (max == c) {
                return;
            }
        }

        if (depth < b) {
            dfs(depth + 1, kcal + arr[depth]);
            dfs(depth + 1, kcal); // 사료를 선택하지 않은 경우
        }

    }

}