package dynamic_programming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class _14494 {
    static final int fibonacci = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] dp = new long[1001][1001];
        dp[1][1] = 1;

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i * j != 1) {
                    dp[i][j] = (dp[i][j - 1] % fibonacci + dp[i - 1][j] % fibonacci + dp[i - 1][j - 1] % fibonacci) % fibonacci;
                }
            }
        }
        System.out.println(dp[n][m] % fibonacci);
    }
}