package dynamic_programming.silver.silver_1;
import java.io.*;
public class _10844 {
    static final int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        for(int i = 1; i <= 9; i++) dp[1][i] = 1; // 첫 번째 자릿수는 경우의 수가 1개밖에 없음

        for(int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1]; // 자릿값이 0이면 이전 자릿수는 1
            dp[i][9] = dp[i - 1][8]; // 자릿값이 9이면 이전 자릿수는 8

            for(int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD; // 자릿값이 1 ~ 8일 때
            }
        }
        long sum = 0;
        for(int  i = 0; i < 10; i++) sum = (sum + dp[n][i]) % MOD;

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
