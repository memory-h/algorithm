package dynamic_programming.silver.silver_1;
import java.io.*;
public class _15993 {
    static final int MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[][] dp = new long[100001][2];
        dp[1][1] = 1; dp[2][0] = 1; dp[2][1] = 1; dp[3][0] = 2; dp[3][1] = 2;

        for(int i = 4; i < 100001; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 3][0]) % MOD;
        }
        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0) {
            int n = Integer.parseInt(br.readLine());
            long odd = dp[n][1] % MOD;
            long even = dp[n][0] % MOD;

            bw.write(odd + " " + even + "\n");
        }
        bw.flush();
        bw.close();
    }
}