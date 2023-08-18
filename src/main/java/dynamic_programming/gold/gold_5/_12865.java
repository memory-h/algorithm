package dynamic_programming.gold.gold_5;
import java.io.*;
import java.util.StringTokenizer;
public class _12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                // 이전 행의 값을 넣고
                dp[i][j] = dp[i - 1][j];

                // 무게가 남으면, (dp[이전 행][넣을 수 있는 무게] + 현재 무게)를 찾아서 현재 값과 비교한다.
                if(w[i] <= j) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i]] + v[i]);
            }
        }
        bw.write(String.valueOf(dp[n][k]));
        bw.flush();
        bw.close();
    }
}