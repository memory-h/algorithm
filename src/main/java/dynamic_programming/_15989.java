package dynamic_programming;
import java.io.*;
public class _15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[][] dp = new long[10001][4];
        dp[1][1] = 1; dp[2][1] = 1; dp[2][2] = 1; dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for(int i = 4; i < 10001; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0){
            int n = Integer.parseInt(br.readLine());
            long result = dp[n][1] + dp[n][2] + dp[n][3];
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}