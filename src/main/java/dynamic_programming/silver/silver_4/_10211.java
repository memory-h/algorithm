package dynamic_programming.silver.silver_4;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n + 1];
            int[] dp = new int[n + 1];
            int result = Integer.MIN_VALUE;
            Arrays.fill(dp, Integer.MIN_VALUE);

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= n; i++) {
                int sum = 0;
                for(int j = i; j <= n; j++) {
                    sum += arr[j];
                    dp[i] = Math.max(dp[i], sum);
                }
                result = Math.max(result, dp[i]);
            }
            sb.append(result + "\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}