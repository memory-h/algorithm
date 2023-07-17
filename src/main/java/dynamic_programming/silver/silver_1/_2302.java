package dynamic_programming.silver.silver_1;
import java.io.*;
public class _2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1; dp[1] = 1; dp[2] = 2;

        for(int i = 3; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];

        int result = 1;
        int tmp = 0;

        while(m --> 0) {
            int num = Integer.parseInt(br.readLine());

            result *= dp[num - tmp - 1];
            tmp = num;
        }
        result *= dp[n - tmp];

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}