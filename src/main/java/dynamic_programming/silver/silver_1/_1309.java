package dynamic_programming.silver.silver_1;

import java.io.*;

public class _1309 {

    static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            // i번째 칸에 사자를 배치하지 않은 경우
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;

            // i번째 칸에 사자를 왼쪽에 배치하는 경우
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;

            // i번째 칸에 사자를 오른쪽에 배치하는 경우
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        long result = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}