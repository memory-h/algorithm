package dynamic_programming.silver.silver_2;
import java.io.*;
public class _1699 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];
        dp[1] = 1;

        int min;
        for(int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
    }
}