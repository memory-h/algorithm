package dynamic_programming.silver.silver_2;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int[] dp = new int[1101];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;
        for(int i = 1; i <= n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            for(int j = 1; j <= arr[i]; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        if(dp[n] == Integer.MAX_VALUE) bw.write("-1");
        else bw.write(String.valueOf(dp[n]));

        bw.flush();
        bw.close();
    }
}