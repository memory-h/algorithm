package back_tracking.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _2961 {

    static int n, min = Integer.MAX_VALUE;
    static int[][] taste;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        taste = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, 0);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int s, int b, int count) {

        if (depth == n) {
            // 재료를 선택했을 때
            if (count != 0) {
                // 신맛과 쓴맛의 차이가 가장 작은 요리의 차이를 구한다.
                min = Math.min(min, Math.abs(s - b));

                return;
            }
        }

        if (depth < n) {
            dfs(depth + 1, s * taste[depth][0], b + taste[depth][1], count + 1);
            dfs(depth + 1, s, b, count); // 재료를 선택하지 않은 경우
        }

    }

}