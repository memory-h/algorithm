package dynamic_programming.silver.silver_1;
import java.io.*;
public class _2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][10];

        for(int i = 0; i <= 9; i++) dp[1][i] = 1;

        for(int i = 2; i <= 64; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        while(testCase --> 0) {
            int n = Integer.parseInt(br.readLine());
            long result  = 0;

            for(int i = 0; i <= 9; i++) result += dp[n][i];
            sb.append(result + "\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}