package dynamic_programming.silver.silver_5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class _25644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int max = 0;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = N - 1; i >= 0; i--) {
            max = Math.max(max, dp[i]);
            result = Math.max(result ,max - dp[i]);
        }
        System.out.println(result);
    }
}