package dynamic_programming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class _15645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[100001][3];
        int[][] dp = new int[100001][3];

        int max, min;

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];

        for(int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + arr[i][1];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]) + arr[i][2];
        }
        max = Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]));

        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];

        for(int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][2];
        }
        min = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));

        System.out.println(max + " " + min);
    }
}