package dynamic_programming.gold.gold_5;
import java.io.*;
import java.util.StringTokenizer;
public class _2225 {
    private final static int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1; i <= n; i++) dp[i][1] = 1;
        for(int i = 1; i <= k; i++) dp[1][i] = i;

        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= k; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                dp[i][j] %= MOD;
            }
        }
        bw.write(String.valueOf(dp[n][k]));
        bw.flush();
        bw.close();
    }
}