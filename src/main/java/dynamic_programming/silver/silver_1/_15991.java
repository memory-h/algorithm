package dynamic_programming.silver.silver_1;
import java.io.*;
public class _15991 {
    static final int MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] dp = new long[100001];
        dp[1] = 1; dp[2] = 2; dp[3] = 2; dp[4] = 3; dp[5] = 3; dp[6] = 6;

        for(int i = 7; i < 100001; i++) dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % MOD;
        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0){
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}