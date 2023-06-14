package dynamic_programming;
import java.io.*;
import java.util.StringTokenizer;
public class _17485 {
    static int n, m;
    static boolean check(int y) {
        if(y < 0 || y >= m) return false;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][][] dp = new int[3][n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < m; i++) {
            dp[0][0][i] = arr[0][i];
            dp[1][0][i] = arr[0][i];
            dp[2][0][i] = arr[0][i];
        }
        for(int i = 0; i < n; i++) {
            dp[0][i][0] = Integer.MAX_VALUE;
            dp[2][i][m - 1] = Integer.MAX_VALUE;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(check(j - 1) && check(j + 1)) {
                    dp[0][i][j] = Math.min(dp[1][i - 1][j - 1], dp[2][i - 1][j - 1]) + arr[i][j];
                    dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + arr[i][j];
                    dp[2][i][j] = Math.min(dp[0][i - 1][j + 1], dp[2][i - 1][j + 1]) + arr[i][j];
                }
                else if(!check(j - 1) && check(j + 1)) {
                    dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + arr[i][j];
                    dp[2][i][j] = Math.min(dp[0][i - 1][j + 1], dp[1][i - 1][j + 1]) + arr[i][j];
                }
                else if(check(j - 1) && !check(j + 1)) {
                    dp[0][i][j] = Math.min(dp[1][i - 1][j - 1], dp[2][i - 1][j - 1]) + arr[i][j];
                    dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + arr[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;

        for(int j = 0; j < m; j++) {
            for(int i = 0; i < 3; i++) {
                if(min > dp[i][n - 1][j]) min = dp[i][n - 1][j];
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}