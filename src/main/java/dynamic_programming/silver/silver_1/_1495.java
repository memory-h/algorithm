package dynamic_programming.silver.silver_1;
import java.io.*;
import java.util.StringTokenizer;
public class _1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] v = new int[n + 1];
        int[][] dp = new int[n + 1][m + 1]; dp[0][s] = 1;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) v[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(dp[i - 1][j] == 0) continue;
                if(j + v[i] <= m) dp[i][j + v[i]] = 1;
                if(j - v[i] >= 0) dp[i][j - v[i]] = 1;
            }
        }
        int result = -1;

        for(int i = m; i >= 0; i--) {
            if(dp[n][i] == 1) {
                result = i;
                break;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}