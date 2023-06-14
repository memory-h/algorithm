package dynamic_programming;
import java.io.*;
import java.util.StringTokenizer;
public class _15992 {
    static final int MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        long[][] dp = new long[1001][1001];
        dp[1][1] = 1; dp[2][1] = 1; dp[2][2] = 1; dp[3][1] = 1; dp[3][2] = 2; dp[3][3] = 1;

        for(int i = 4; i < 1001; i++) {
            dp[i][i] = 1;
            for(int j = 2; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % MOD;
            }
        }
        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write(dp[n][m] + "\n");
        }
        bw.flush();
        bw.close();
    }
}