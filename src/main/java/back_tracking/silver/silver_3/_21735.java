package back_tracking.silver.silver_3;

import java.io.*;
import java.util.StringTokenizer;

public class _21735 {

    static int n, m, max = 0;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[101];
        visited = new boolean[101];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 1);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    private static void dfs(int time, int position, int snowball) {

        // 대회가 끝났거나, 눈덩이가 앞마당 끝에 도달한 경우
        if (time == m || position == n) {
            max = Math.max(max, snowball);

            return;
        }

        // 눈덩이를 현재 위치 +1 칸으로 굴린 경우
        if (position + 1 <= n) {
            dfs(time + 1, position + 1, snowball + arr[position + 1]);
        }

        // 눈덩이를 현재 위치 +2칸으로 던진 경우
        if (position + 2 <= n) {
            dfs(time + 1, position + 2, (snowball / 2) + arr[position + 2]);
        }

    }

}