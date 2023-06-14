package dynamic_programming;
import java.io.*;
import java.util.StringTokenizer;
public class _14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 2];
        int[] p = new int[n + 2];
        int[] dp = new int[n + 2];
        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < n + 2; i++) {
            max = Math.max(max, dp[i]);
            if(i + t[i] <= n + 1) dp[i + t[i]] = Math.max(dp[i + t[i]], max + p[i]);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}