package dynamic_programming.silver.silver_1;
import java.io.*;
public class _12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[10000001]; dp[1] = 0;
        int cache[] = new int[10000001];

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            cache[i] = i - 1;

            if(i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                cache[i] = i / 2;
            }
            if(i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                cache[i] = i / 3;
            }
        }
        sb.append(dp[n] + "\n");

        while(n > 0) {
            sb.append(n + " ");
            n = cache[n];
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}