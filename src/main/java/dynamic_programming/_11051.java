package dynamic_programming;
import java.io.*;
import java.util.StringTokenizer;
public class _11051 {
    static int[][] dp;
    static final int binomial = 10007;
    public static int power(int n, int k) {
        if(k == 0 || k == n) return 1;

        if(dp[n][k] == 0) dp[n][k] = (power(n - 1, k - 1) + power(n - 1, k)) % binomial;

        return dp[n][k];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];

        int result = power(N, K) % binomial;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}